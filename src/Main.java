import controller.MainController;
import java.util.ArrayList;
import java.util.List;
import domain.*;
import domain.Thing;

public class Main {
	private static void testGeneration() {
		// testing raw List
		var list = new readers.RandomReader(new readingStrategy.CarReadingStrategy(), 5).read();
		Utility.dumpList(list);
		list = new readers.RandomReader(new readingStrategy.BookReadingStrategy(), 5).read();
		Utility.dumpList(list);
		list = new readers.RandomReader(new readingStrategy.VegetableReadingStrategy(), 5).read();
		Utility.dumpList(list);
	}

	static <T extends Thing> void prompt(T vart) {
		String type = vart.getClass().getSimpleName();
		System.out.println(type);
	}

	static <T extends Thing> void testStrange() {
		var list = new readers.RandomReader<Car>(new readingstrategy.CarReadingStrategy(), 5).read();
		utility.Utility.dumpList(list);
		var ctrl = new controller.ControllerStrangeSort<Car>(list);
		ctrl.run();
	}

	public static void main(String[] args) {
		testStrange();
	}
}
