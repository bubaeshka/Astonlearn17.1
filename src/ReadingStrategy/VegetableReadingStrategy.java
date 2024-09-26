package ReadingStrategy;

import domain.Vegetable;
import domain.Thing;

import java.util.Map;

public class VegetableReadingStrategy extends BaseReadingStrategy {

    public VegetableReadingStrategy() {
        fieldsDescriptions = new FieldDescription[] {
                new FieldDescription("название", FieldDescription.Type.STRING,
                        new Validators.StringLengthValidator(32)),
                new FieldDescription("вес", FieldDescription.Type.INT,
                        new Validators.IntBoundsValidator(100, 10180)),
                new FieldDescription("цвет", FieldDescription.Type.STRING,
                        new Validators.StringLengthValidator(32)) };
    }

    @Override
    public FieldDescription[] getNeededFields() {
        return fieldsDescriptions;
    }

    @Override
    public Thing createThing(String[] inputfields) {
        return new Vegetable.Builder(inputfields[0])
                .setWeight(Integer.parseInt(inputfields[1]))
                .setColor(inputfields[2]).build();
    }

    @Override
    public Thing createThing(Map<String, String> inputfields) {
        return null;
    }


}
