package readers;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

import domain.Thing;
import readingstrategy.BaseReadingStrategy;
import readingstrategy.FieldDescription;

public class RandomReader<T extends Thing> extends BaseReader<T> {
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
            if (fd.validator instanceof validators.IntBoundsValidator) {
                int min = ((validators.IntBoundsValidator) fd.validator).getMin();
                int max = ((validators.IntBoundsValidator) fd.validator).getMax();
                return String.valueOf(rng.nextInt(max - min + 1) + min);
            }
            return String.valueOf((int) (Math.random() * 100));
        } else if (fd.type == FieldDescription.Type.STRING) {
            int maxLenth = ((validators.StringLengthValidator) fd.validator).getMaxLength();
            int minLenth = Math.min(maxLenth, 3);
            int len = rng.nextInt(maxLenth - minLenth + 1) + minLenth;
            return generateRandomString(len);
        }
        throw new IllegalArgumentException("unknown field type encountered");
    }

    @Override
    public List<T> read() {
        ArrayList<Thing> collection = new ArrayList<>();
        FieldDescription[] fds = strategy.getNeededFields();
        int elemCount = fds.length;
        for (int i = 0; i < count; i++) {
            String[] fields = new String[elemCount];
            for (int j = 0; j < elemCount; j++) {
                fields[j] = generate(fds[j]);
            }
            if (!strategy.validate(fields).isValid) {
                i--;
                continue;
            }
            
            collection.add(strategy.createThing(fields));
            //какой то странный дубль?
            //collection.add((Thing) strategy.createThing(fields));

        }
        return (List<T>) collection;
    }

}
