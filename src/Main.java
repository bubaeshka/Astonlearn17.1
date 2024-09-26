import controller.MainController;
import java.util.ArrayList;
import java.util.List;
import domain.*;
import java.lang.reflect.Field;
import java.net.http.HttpResponse.PushPromiseHandler;

public class Main {
	private static void testGeneration() {
		// testing raw List
		var list = new readers.RandomReader(new ReadingStrategy.CarReadingStrategy(), 5).read();
		Utility.dumpList(list);
		list = new readers.RandomReader(new ReadingStrategy.BookReadingStrategy(), 5).read();
		Utility.dumpList(list);
		list = new readers.RandomReader(new ReadingStrategy.VegetableReadingStrategy(), 5).read();
		Utility.dumpList(list);
	}

	static <T extends Thing> void prompt(T vart) {
		String type = vart.getClass().getSimpleName();
		System.out.println(type);
	}

	public static void main(String[] args) {
		MainController.getInstance().run();
	}
}
