package readingstrategy;

import domain.Car;
import domain.Thing;

public class CarReadingStrategy extends BaseReadingStrategy {

    public CarReadingStrategy() {
        fieldsDescriptions = new FieldDescription[] {
                new FieldDescription("модель", FieldDescription.Type.STRING,
                        new validators.StringLengthValidator(10)),
                new FieldDescription("год выпуска", FieldDescription.Type.INT,
                        new validators.IntBoundsValidator(1880, 2024)),
                new FieldDescription("мощность", FieldDescription.Type.INT,
                        new validators.IntBoundsValidator(10, 600)) };
    }

    @Override
    public FieldDescription[] getNeededFields() {
        return fieldsDescriptions;
    }

    @Override
    public Thing createThing(String[] inputfields) {
        return new Car.Builder(inputfields[0])
                .setMadeYear(Integer.parseInt(inputfields[1]))
                .setPower(Integer.parseInt(inputfields[2])).build();
    }

}
