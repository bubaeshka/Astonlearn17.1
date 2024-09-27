package readingstrategy;

import domain.Vegetable;
import domain.Thing;

public class VegetableReadingStrategy extends BaseReadingStrategy {

    public VegetableReadingStrategy() {
        fieldsDescriptions = new FieldDescription[] {
                new FieldDescription("название", FieldDescription.Type.STRING,
                        new validators.StringLengthValidator(32)),
                new FieldDescription("вес", FieldDescription.Type.INT,
                        new validators.IntBoundsValidator(10, 10180)),
                new FieldDescription("цвет", FieldDescription.Type.STRING,
                        new validators.StringLengthValidator(32)) };
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

}
