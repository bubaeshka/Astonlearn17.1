package controller;

import domain.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;

public final class controllerStrangeSort<T extends Thing> {

//	enum carIntGetters {
//		WEIGHT("во весу", (Car car) -> car.getMadeYear()),
//		SPEED("по скорости", (Car car) -> car.getPower());
//		
//		private final String displayString;
//		ToIntFunction<Car> getter;
//
//	private carIntGetters(String displayString, ToIntFunction<Car> getter) {
//
//        this.getter=getter;
//        this.displayString = displayString;
//        
//    }
//
//	}

	enum CollectionType {
		CAR("Автомобиль"), BOOK("Книга"), VEGETABLE("Корнеплод");

		private final String name;
		private ArrayList<String> pseudonyms = new ArrayList<>();

		private void setPseudonym(String pseudonym) {
			this.pseudonyms.add(pseudonym);
		}

		private CollectionType(String name) {
			this.name = name;
			setPseudonym(name);
			setPseudonym(String.valueOf(this.ordinal() + 1));
			setPseudonym(this.ordinal() + 1 + ". " + this.getName());
		}

		public String getName() {
			return name;
		}

		public ArrayList<String> getPseudonyms() {
			return pseudonyms;
		}
	}

	private List<T> lst;

	public controllerStrangeSort(List<T> lst) {
		this.lst = lst;
	}

	ToIntFunction<T> promptKey() {
		System.out.println("выберите по какому ключу осуществить странную сортировку:");
		return car->((Car)car).getMadeYear();
	}

	public void run() {
		System.out.println("Работаем с коллекцией " + lst.getClass().getSimpleName());
		ToIntFunction<T> getter = promptKey();
		Utility.strangeSort(lst, getter);
		Utility.dumpList(lst);
	}
}
