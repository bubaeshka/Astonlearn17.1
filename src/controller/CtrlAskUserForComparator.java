package controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

import domain.Book;
import domain.Car;
import domain.Vegetable;

public class CtrlAskUserForComparator<T> {
	String typeName;
	private HashMap<String, HashMap<String, Comparator<T>>> keyGettersStorage;

	@SuppressWarnings("unchecked")
	public CtrlAskUserForComparator(String typename) {
		this.typeName = typename;

		keyGettersStorage = new HashMap<>();

		keyGettersStorage.put("Car", new HashMap<>());
		keyGettersStorage.get("Car").put("модель", (Comparator<T>) Comparator.comparing(Car::getName));
		keyGettersStorage.get("Car").put("год выпуска", (Comparator<T>) Comparator.comparing(Car::getMadeYear));
		keyGettersStorage.get("Car").put("мощность", (Comparator<T>) Comparator.comparing(Car::getPower));

		keyGettersStorage.put("Book", new HashMap<>());
		keyGettersStorage.get("Book").put("название", (Comparator<T>) Comparator.comparing(Book::getName));
		keyGettersStorage.get("Book").put("автор", (Comparator<T>) Comparator.comparing(Book::getAuthor));
		keyGettersStorage.get("Book").put("количество страниц", (Comparator<T>) Comparator.comparing(Book::getPages));

		keyGettersStorage.put("Vegetable", new HashMap<>());
		keyGettersStorage.get("Vegetable").put("вид", (Comparator<T>) Comparator.comparing(Vegetable::getName));
		keyGettersStorage.get("Vegetable").put("вес", (Comparator<T>) Comparator.comparing(Vegetable::getWeight));
		keyGettersStorage.get("Vegetable").put("цвет", (Comparator<T>) Comparator.comparing(Vegetable::getColor));
	}

	Comparator<T> promptComparator(HashMap<String, Comparator<T>> gettersStorage, String message) {
		try (Scanner in = new Scanner(System.in)) {
			var funcList = new ArrayList<Comparator<T>>();
			System.out.println(message);
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
				if (key == -1) {
					break;
				}
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

	public Comparator<T> run(String message) {
		Comparator<T> cmp = promptComparator(keyGettersStorage.get(typeName), message);
		return cmp;
	}
}
