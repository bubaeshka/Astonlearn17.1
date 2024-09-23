package ReadingStrategy;

public class FieldDescription {
	enum FieldType {
		STRING, INT 
	}
	public FieldDescription(String fieldName, FieldDescription.FieldType fieldType) {
		super();
		this.fieldName = fieldName;
		this.fieldType = fieldType;
	}
	String fieldName;
	public FieldDescription.FieldType fieldType;
}