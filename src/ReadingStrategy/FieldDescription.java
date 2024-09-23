package ReadingStrategy;

public class FieldDescription {
	public enum FieldType {
		STRING, INT 
	}
	public FieldDescription(String fieldName, FieldDescription.FieldType fieldType) {
		super();
		this.fieldName = fieldName;
		this.fieldType = fieldType;
	}
	public String fieldName;
	public FieldDescription.FieldType fieldType;
}