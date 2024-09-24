package Validators;

public class ValidationResult {
    public final boolean isValid; // default package visibility
    public final String errorMessage; // default package visibility

    public ValidationResult(boolean isValid, String errorMessage) {
        super();
        this.isValid = isValid;
        this.errorMessage = errorMessage;
    }
}
