package ReadingStrategy;

import domain.Thing;

public class CarReadingStrategy extends BaseReadingStrategy {

	private FieldDescription[] fieldsDescriptions;
	public CarReadingStrategy() {
		fieldsDescriptions = new FieldDescription[] {
				new FieldDescription("модель", FieldDescription.Type.STRING,new Validators.StringLengthValidator(10)),
				new FieldDescription("год выпуска", FieldDescription.Type.INT, new Validators.IntBoundsValidator(1880, 2024)),
				new FieldDescription("мощность", FieldDescription.Type.INT,new Validators.IntBoundsValidator(10, 600))
		};
	}

    @Override
    public FieldDescription[] getNeededFields() {
        return fieldsDescriptions;
    }

    @Override
    public Thing createThing(String[] inputfields) {
        return new domain.Car(inputfields[0], Integer.parseInt(inputfields[1]), Integer.parseInt(inputfields[2]));
    }

	@Override
	public boolean validate(String[] inputfields) {
		//no validation still realized all parameters are ok	
		return true;
	}

}
