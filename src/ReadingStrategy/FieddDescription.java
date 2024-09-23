package ReadingStrategy;

public class FieddDescription {
	enum FieldType {
		STRING, INT 
	}
	public FieddDescription(String fieldName, FieddDescription.FieldType fieldType) {
		super();
		this.fieldName = fieldName;
		this.fieldType = fieldType;
	}
	String fieldName;
	FieddDescription.FieldType fieldType;
}