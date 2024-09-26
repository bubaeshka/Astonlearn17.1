package readers;

import domain.Thing;
import readingstrategy.BaseReadingStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsoleReader <T extends Thing> extends BaseReader<T>{

    public ConsoleReader(BaseReadingStrategy strategy) {
        super(strategy);
    }



    public List<T> read() {
        ArrayList<Thing> collection = new ArrayList<>();

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String inputstring = "*";
        Map<String, String> mapfields = new HashMap<>();
        do {
            System.out.println("Чтобы пропустить ввод, введите --. Для выхода ведите *");
            for (int i = 0; i<strategy.getNeededFields().length; i++) {
                System.out.println("Ведите "+strategy.getNeededFields()[i].name);
                try {
                    inputstring = console.readLine();
                    if (inputstring.equals("*")) return (List<T>) collection;;
                    if (!inputstring.equals("--")) mapfields.put(strategy.getNeededFields()[i].name, inputstring);
                } catch (IOException e) {
                    System.out.println("Вы ввели неправильные данные");
                    throw new RuntimeException(e);
                }
            }
            if (strategy.validate(mapfields).isValid) collection.add(strategy.createThing(mapfields));
            //String[] mas_fields = mapfields.values().toArray(new String[0]);
            //if (strategy.validate(mas_fields).isValid) collection.add(strategy.createThing(mas_fields));
        } while(!inputstring.equals("*"));

        return (List<T>) collection;
    }
}
