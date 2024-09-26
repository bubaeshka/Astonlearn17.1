package readers;

import ReadingStrategy.BaseReadingStrategy;
import domain.Thing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleReader <T extends Thing> extends BaseReader<T>{

    public ConsoleReader(BaseReadingStrategy strategy) {
        super(strategy);
    }



    public List<T> read() {
        ArrayList<Thing> collection = new ArrayList<>();

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String inputstring = "*";
        ArrayList<String> fields = new ArrayList<>();
        do {
            System.out.println("Для выхода ведите *");
            for (int i = 0; i<strategy.getNeededFields().length; i++) {
                System.out.println("Ведите "+strategy.getNeededFields()[i].name);
                try {
                    inputstring = console.readLine();
                    if (inputstring.equals("*")) break;
                    if (!inputstring.isEmpty()) fields.add(inputstring);
                } catch (IOException e) {
                    System.out.println("Вы ввели неправильные данные");
                    throw new RuntimeException(e);
                }
            }
            if (strategy.validate(fields.toArray(new String[fields.size()])).isValid) collection.add(strategy.createThing(fields));
        } while(!inputstring.equals("*"));

        return (List<T>) collection;
    }
}
