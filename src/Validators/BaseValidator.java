package Validators;

public class BaseValidator {

    public ValidationResult validate(String s) {
        return new ValidationResult(true, "");
    }
}
