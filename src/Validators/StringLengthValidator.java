package Validators;

public class StringLengthValidator extends BaseValidator {
private int maxLength;

    public StringLengthValidator(int length) {
        this.maxLength=length;
    }

}
