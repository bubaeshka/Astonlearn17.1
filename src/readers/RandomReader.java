package readers;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

import ReadingStrategy.BaseReadingStrategy;
import ReadingStrategy.FieldDescription;
import domain.Thing;

public class RandomReader<T> extends BaseReader {
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
            if (fd.validator instanceof Validators.IntBoundsValidator) {
                int min = ((Validators.IntBoundsValidator) fd.validator).getMin();
                int max = ((Validators.IntBoundsValidator) fd.validator).getMax();
                return String.valueOf(rng.nextInt(max - min + 1) + min);
            }
            return String.valueOf((int) (Math.random() * 100));
        } else if (fd.type == FieldDescription.Type.STRING) {
            int maxLenth = ((Validators.StringLengthValidator) fd.validator).getMaxLength();
            int minLenth = Math.min(maxLenth, 3);
            int len = rng.nextInt(maxLenth - minLenth + 1) + minLenth;
            return generateRandomString(len);
        }
        throw new IllegalArgumentException("unknown field type encountered");
    }

    @Override
    public List<T> read() {
        var collection = new ArrayList<T>();
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
            
            collection.add((T) strategy.createThing(fields));
            //collection.add((Thing) strategy.createThing(fields));

        }
        return collection;
    }

}
