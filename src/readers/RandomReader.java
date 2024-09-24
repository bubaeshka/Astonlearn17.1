package readers;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

import ReadingStrategy.BaseReadingStrategy;
import ReadingStrategy.FieldDescription;
import domain.Thing;

public class RandomReader extends BaseReader {
    private int count;
    private Random rng;

    public RandomReader(BaseReadingStrategy strategy, int count) {
        super(strategy);
        this.count = count;
        rng = new Random(124);
    }

    String generateRandomString(int len) {
        String res = new String();
        for (int i = 0; i < len; i++) {
            char ch = (char) ((int) 'A' + (int) (rng.nextInt(26)));
            res = res + ch;
        }
        return res;
    }

    String generate(FieldDescription fd) {
        if (fd.type == FieldDescription.Type.INT) {
            return String.valueOf((int) (Math.random() * 100));
        } else if (fd.type == FieldDescription.Type.STRING) {
            return generateRandomString(8);
        }
        throw new IllegalArgumentException("unknown field type encountered");
    }

    @Override
    public
    List<Thing> read() {
        ArrayList<Thing> collection = new ArrayList<>();
        FieldDescription[] fds = strategy.getNeededFields();
        int elemCount = fds.length;
        for (int i = 0; i < count; i++) {
            String[] fields = new String[elemCount];
            for (int j = 0; j < elemCount; j++) {
                fields[j] = generate(fds[j]);
            }
            collection.add(strategy.createThing(fields));

        }
        return collection;
    }
}
