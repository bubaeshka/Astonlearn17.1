package readers;

import domain.Thing;
import readingstrategy.BaseReadingStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
            fields.clear();
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
            String[] mas_fields = fields.toArray(new String[fields.size()]);
            if (strategy.validate(mas_fields).isValid) {
                collection.add(strategy.createThing(mas_fields));
            }
        } while(!inputstring.equals("*"));

        return (List<T>) collection;
    }
}
