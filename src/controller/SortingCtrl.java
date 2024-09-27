package controller;

import java.util.Comparator;
import java.util.List;
import domain.Thing;

public class SortingCtrl<T extends Thing> {
	private List<T> lst;
	String typeName;

	public SortingCtrl(List<T> lst) {
		this.lst = lst;
	}

	public void run() {
		if (lst == null || lst.size() == 0) {
			System.out.println("Коллекция пуста, не с чем работать");
			return;
		}
		typeName = lst.getFirst().getClass().getSimpleName();
		System.out.println("Работаем с коллекцией " + typeName);
		var cmpAsker = new CtrlAskUserForComparator<T>(typeName);
		Comparator<T> cmp = cmpAsker.run("выберите по каким ключам осуществить сортировку:");
		utility.Utility.sort(lst, cmp);
		utility.Utility.dumpList(lst);
	}
}
