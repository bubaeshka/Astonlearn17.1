package ReadingStrategy;

import Validators.ValidationResult;
import domain.Thing;

import java.util.Map;

// this strategy intended to be used by "fillers"

// get info getNeededFieds(), prepare field content from input, 
// organize it into array in order corresponding to getNeededFields()
// then pass it to validate(), if successful then pass it to createThing().
// Fresh baked Thing object add to collection and cycle again

public abstract class BaseReadingStrategy {
    protected FieldDescription[] fieldsDescriptions;

    abstract public FieldDescription[] getNeededFields();

    // the order of input fields SHOULD be the same as in getNeededFields
    abstract public Thing createThing(String[] inputfields);
    abstract public Thing createThing(Map<String,String> inputfields);

    public ValidationResult validate(Map<String,String> inputfields) {
        StringBuilder errorMessages = new StringBuilder();
        boolean res = false;
        for (var entry : inputfields.entrySet()) {
           res = false;
            for (FieldDescription fieldsDescription : fieldsDescriptions) {
                if (entry.getKey().equals(fieldsDescription.name)) {
                    ValidationResult vr = fieldsDescription.validator.validate(entry.getValue());
                    if (!vr.isValid) {
                        errorMessages.append("ошибка в поле ");
                        errorMessages.append(fieldsDescription.name);
                        errorMessages.append(": ");
                        errorMessages.append(vr.errorMessage);
                        errorMessages.append("\n");
                        return new ValidationResult(res, errorMessages.toString());
                    }
                    res = true;
                    break;
                }
            }
        }
        return new ValidationResult(res, errorMessages.toString());
    }

    // the order of input fields SHOULD be the same as in getNeededFields
    public ValidationResult validate(String[] inputfields) {
        if (fieldsDescriptions.length != inputfields.length) {
            return new ValidationResult(false, "количество входных полей не совпадает с требуемым. Требуется "
                    + fieldsDescriptions.length + " полей");
        }
        StringBuilder errorMessages = new StringBuilder();
        boolean res = true;
        for (int i = 0; i < fieldsDescriptions.length; ++i) {
            ValidationResult vr = fieldsDescriptions[i].validator.validate(inputfields[i]);
            if (!vr.isValid) {
                res = false;
                errorMessages.append("ошибка в поле ");
                errorMessages.append(fieldsDescriptions[i].name);
                errorMessages.append(": ");
                errorMessages.append(vr.errorMessage);
                errorMessages.append("\n");
            }
        }
        return new ValidationResult(res, errorMessages.toString());
    }
}
