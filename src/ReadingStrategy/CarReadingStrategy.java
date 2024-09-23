package ReadingStrategy;

import domain.Thing;

public class CarReadingStrategy extends BaseReadingStrategy {

	private FieddDescription[] fieldsDescriptions;
	public CarReadingStrategy() {
		fieldsDescriptions = new FieddDescription[] {
				new FieddDescription("модель", FieddDescription.FieldType.STRING),
				new FieddDescription("год выпуска", FieddDescription.FieldType.INT),
				new FieddDescription("мощность", FieddDescription.FieldType.INT)
		};
	}

	@Override
	public FieddDescription[] getNeededFieds() {
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
