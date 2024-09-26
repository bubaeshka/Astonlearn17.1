import java.util.ArrayList;
import java.util.List;
import domain.*;

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

	public static void main(String[] args) {
		testGeneration();
	}
}