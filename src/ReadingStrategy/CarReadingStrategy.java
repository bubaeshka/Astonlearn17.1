package ReadingStrategy;

import domain.Car;

public class CarReadingStrategy extends BaseReadingStrategy<Car> {

    public CarReadingStrategy() {
        fieldsDescriptions = new FieldDescription[] {
                new FieldDescription("модель", FieldDescription.Type.STRING, new Validators.StringLengthValidator(10)),
                new FieldDescription("год выпуска", FieldDescription.Type.INT,
                        new Validators.IntBoundsValidator(1880, 2024)),
                new FieldDescription("мощность", FieldDescription.Type.INT,
                        new Validators.IntBoundsValidator(10, 600)) };
    }

    @Override
    public FieldDescription[] getNeededFields() {
        return fieldsDescriptions;
    }

    @Override
    public Car createThing(String[] inputfields) {
        return new domain.Car(inputfields[0], Integer.parseInt(inputfields[1]), Integer.parseInt(inputfields[2]));
    }

}
