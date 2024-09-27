import controller.MainController;
import java.util.ArrayList;
import java.util.List;
import domain.*;
import domain.Thing;

public class Main {

	static <T extends Thing> void prompt(T vart) {
		String type = vart.getClass().getSimpleName();
		System.out.println(type);
	}

	static  void testStrange() {
		var list = new readers.RandomReader<Car>(new readingstrategy.CarReadingStrategy(), 5).read();
		utility.Utility.dumpList(list);
		var ctrl = new controller.ControllerStrangeSort<Car>(list);
		ctrl.run();
	}
	static void testSort() {
		var list = new readers.RandomReader<Car>(new readingstrategy.CarReadingStrategy(), 5).read();
		utility.Utility.dumpList(list);
		var ctrl = new controller.SortingCtrl<Car>(list);
		ctrl.run();
	}

	public static void main(String[] args) {
		testSort();
	}
}
