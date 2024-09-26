package validators;

public class StringLengthValidator extends BaseValidator {
    private int maxLength;

    public StringLengthValidator(int length) {
        this.maxLength = length;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public ValidationResult validate(String s) {
        if (s.length() > maxLength)
            return new ValidationResult(false, "длина строки больше допустимой длины в " + maxLength + " символов");
        return new ValidationResult(true, "");
    }

}
