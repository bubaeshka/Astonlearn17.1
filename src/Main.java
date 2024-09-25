import java.util.ArrayList;
import java.util.List;
import domain.*;

public class Main {
    public static void main(String[] args) {

        // testing raw List
        var list = new readers.RandomReader(new ReadingStrategy.CarReadingStrategy(), 5).read();
        for (var thing : list) {
            System.out.println(thing);
        }
        System.out.println();

        list = new readers.RandomReader(new ReadingStrategy.BookReadingStrategy(), 5).read();
        for (var thing : list) {
            System.out.println(thing);
        }
        System.out.println();

        list = new readers.RandomReader(new ReadingStrategy.VegetableReadingStrategy(), 5).read();
        for (var thing : list) {
            System.out.println(thing);
        }
        System.out.println();




    }
}