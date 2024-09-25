import java.util.ArrayList;
import java.util.List;
import domain.*;

public class Main {
    public static void main(String[] args) {
        List<Thing> list = new readers.RandomReader(new ReadingStrategy.CarReadingStrategy(), 5).read();
        for (Thing thing : list) {
            System.out.println(thing);
        }
    }
}