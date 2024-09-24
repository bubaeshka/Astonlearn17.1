package ReadingStrategy;

import Validators.BaseValidator;


public class FieldDescription {
	public enum Type {
		STRING, INT 
	}
	public BaseValidator validator;
	public FieldDescription(String name, FieldDescription.Type type, BaseValidator validator) {
		super();
		this.name = name;
		this.type = type;
		this.validator=validator;
	}
    public String name;
    public Type type;

}