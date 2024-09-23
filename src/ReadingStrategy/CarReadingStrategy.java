package ReadingStrategy;

import domain.Thing;

public class CarReadingStrategy extends BaseReadingStrategy {

	private FieldDescription[] fieldsDescriptions;
	public CarReadingStrategy() {
		fieldsDescriptions = new FieldDescription[] {
				new FieldDescription("модель", FieldDescription.FieldType.STRING),
				new FieldDescription("год выпуска", FieldDescription.FieldType.INT),
				new FieldDescription("мощность", FieldDescription.FieldType.INT)
		};
	}

	@Override
	public FieldDescription[] getNeededFieds() {
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
