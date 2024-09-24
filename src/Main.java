import java.util.Comparator;
import java.util.List;
import domain.*;

public class Main {

    class MyComparator implements Comparator<Car> {
        @Override
        public int compare(Car o1, Car o2) {
            return o1.getPower() - o2.getPower();
        }
    }

    public static void main(String[] args) {

        List<Car> list = new readers.RandomReader<Car>(new ReadingStrategy.CarReadingStrategy(), 5).read();
        for (Thing thing : list) {
            System.out.println(thing);
        }
        System.out.println();

        Utility.sort(list);
        for (Thing thing : list) {
            System.out.println(thing);
        }
        System.out.println();
        /*
         * Utility.sort(list,new MyComparator()); for (Thing thing : list) {
         * System.out.println(thing); } System.out.println();
         */

    }
}