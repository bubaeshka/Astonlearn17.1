package controller;

import domain.Thing;
import java.util.List;

public final class controllerStrangeSort<T extends Thing> {

	private List<T> lst;

	public controllerStrangeSort(List<T> lst) {
		this.lst = lst;
	}

	public void run() {
		System.out.println("Работаем с коллекцией " + lst.getClass().getSimpleName());

	}
}
