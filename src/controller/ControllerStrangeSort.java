package controller;

import domain.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.function.ToIntFunction;

public final class ControllerStrangeSort<T extends Thing> {

	private List<T> lst;

	public ControllerStrangeSort(List<T> lst) {
		this.lst = lst;
	}

	static private HashMap<String, HashMap<String, ToIntFunction<? extends Thing>>> keyGettersStorage;
	static {
		keyGettersStorage = new HashMap<String, HashMap<String, ToIntFunction<? extends Thing>>>();
		keyGettersStorage.put("Car", new HashMap<String, ToIntFunction<? extends Thing>>());
		keyGettersStorage.get("Car").put("год выпуска", (Car car) -> car.getMadeYear());
		keyGettersStorage.get("Car").put("мощность", (Car car) -> car.getPower());

		keyGettersStorage.put("Book", new HashMap<String, ToIntFunction<? extends Thing>>());
		keyGettersStorage.get("Book").put("количество страниц", (Book book) -> book.getPages());

		keyGettersStorage.put("Vegetable", new HashMap<String, ToIntFunction<? extends Thing>>());
		keyGettersStorage.get("Vegetable").put("вес", (Vegetable vegetable) -> vegetable.getWeight());

	}

	ToIntFunction<? extends Thing> promptKey(HashMap<String, ToIntFunction<? extends Thing>> typedKeyGettersStorage) {
		try (Scanner in = new Scanner(System.in)) {
			System.out.println("выберите по какому ключу осуществить странную сортировку:");
			var keyList = new ArrayList<>(typedKeyGettersStorage.keySet());
			if (keyList.size() == 0) {
				System.out.println("Нет ни одного ключа для сортировки");
				return null;
			}
			if (keyList.size() == 1) {
				return typedKeyGettersStorage.get(keyList.get(0));
			}
			for (int i = 0; i < keyList.size(); i++) {
				System.out.println(i + " - " + keyList.get(i));
			}
			while (true) {
				System.out.println("введите номер ключа");
				int key;
				try {
					key = in.nextInt();
				} catch (java.util.InputMismatchException e) {
					System.out.println("Вы ввели неправильные данные");
					in.nextLine();
					key = -1;
				}
				if (key >= 0 && key < keyList.size()) {
					return typedKeyGettersStorage.get(keyList.get(key));
				}
			}
		}
	}

	public void run() {
		if (lst == null || lst.size() == 0) {
			System.out.println("Коллекция пуста, не с чем работать");
			return;
		}
		String typeName = lst.getFirst().getClass().getSimpleName();
		System.out.println("Работаем с коллекцией " + typeName);
		// not clear how this cast works, but it works
		@SuppressWarnings("unchecked")
		ToIntFunction<T> getter = (ToIntFunction<T>) promptKey(keyGettersStorage.get(typeName));
		utility.Utility.strangeSort(lst, getter);
		utility.Utility.dumpList(lst);

	}
}
