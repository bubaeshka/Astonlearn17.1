package ReadingStrategy;

public class FieldDescription {
	public enum Type {
		STRING, INT 
	}
	public FieldDescription(String fieldName, FieldDescription.FieldType fieldType) {
		super();
		this.name = name;
		this.type = type;
	}
    public String name;
    public Type type;
}