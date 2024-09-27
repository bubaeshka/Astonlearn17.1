package controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.lang.Comparable;

import domain.*;

public class SortingCtrl<T extends Thing> {
	private List<T> lst;
	String typeName;
	private HashMap<String, HashMap<String, Comparator<T>>> keyGettersStorage;

	@SuppressWarnings("unchecked")
	public SortingCtrl(List<T> lst) {
		this.lst = lst;

		keyGettersStorage = new HashMap<String, HashMap<String, Comparator<T>>>();

		keyGettersStorage.put("Car", new HashMap<String, Comparator<T>>());
		keyGettersStorage.get("Car").put("модель", (Comparator<T>) Comparator.comparing(Car::getName));
		keyGettersStorage.get("Car").put("год выпуска", (Comparator<T>) Comparator.comparing(Car::getMadeYear));
		keyGettersStorage.get("Car").put("мощность", (Comparator<T>) Comparator.comparing(Car::getPower));

		keyGettersStorage.put("Book", new HashMap<String, Comparator<T>>());
		keyGettersStorage.get("Book").put("название", (Comparator<T>) Comparator.comparing(Book::getName));
		keyGettersStorage.get("Book").put("автор", (Comparator<T>) Comparator.comparing(Book::getAuthor));
		keyGettersStorage.get("Book").put("количество страниц", (Comparator<T>) Comparator.comparing(Book::getPages));

		keyGettersStorage.put("Vegetable", new HashMap<String, Comparator<T>>());
		keyGettersStorage.get("Vegetable").put("вид", (Comparator<T>) Comparator.comparing(Vegetable::getName));
		keyGettersStorage.get("Vegetable").put("вес", (Comparator<T>) Comparator.comparing(Vegetable::getWeight));
		keyGettersStorage.get("Vegetable").put("цвет", (Comparator<T>) Comparator.comparing(Vegetable::getColor));
	}

	Comparator<T> promptComparator(HashMap<String, Comparator<T>> gettersStorage) {
		try (Scanner in = new Scanner(System.in)) {
			var funcList = new ArrayList<Comparator<T>>();
			System.out.println("выберите по каким ключам осуществить сортировку:");
			var keyList = new ArrayList<>(gettersStorage.keySet());
			if (keyList.size() == 0) {
				System.out.println("Нет ни одного доступного ключа для сортировки, это ошибка");
				return null;
			}
			if (keyList.size() == 1) {
				return gettersStorage.get(keyList.get(0));
			}
			for (int i = 0; i < keyList.size(); i++) {
				System.out.println(i + " - " + keyList.get(i));
			}
			while (true) {
				System.out.println("введите номер ключа либо -1 для завершения выбора");
				int key;
				try {
					key = in.nextInt();
				} catch (java.util.InputMismatchException e) {
					System.out.println("Вы ввели неправильные данные");
					in.nextLine();
					key = -2;
				}
				if (key >= 0 && key < keyList.size()) {
					funcList.add(gettersStorage.get(keyList.get(key)));
					continue;
				}
				if (key == -1)
					break;
			}
			if (funcList.size() == 0) {
				System.out.println("не было выбрано ни одного ключа");
				return null;
			}
			Comparator<T> res = funcList.get(0);
			for (int i = 1; i < funcList.size(); ++i) {
				res = res.thenComparing(funcList.get(i));
			}
			return res;
		}
	}

	public void run() {
		if (lst == null || lst.size() == 0) {
			System.out.println("Коллекция пуста, не с чем работать");
			return;
		}
		typeName = lst.getFirst().getClass().getSimpleName();
		System.out.println("Работаем с коллекцией " + typeName);
		Comparator<T> cmp = promptComparator(keyGettersStorage.get(typeName));
		utility.Utility.sort(lst, cmp);
		utility.Utility.dumpList(lst);
	}
}
