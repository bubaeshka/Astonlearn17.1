package readingstrategy;

import domain.Thing;
import validators.ValidationResult;

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
                errorMessages.append(" \" ");
                errorMessages.append(fieldsDescriptions[i].name);
                errorMessages.append(" \" ");
                errorMessages.append(": ");
                errorMessages.append(vr.errorMessage);
                errorMessages.append("\n");

            }
        }
        return new ValidationResult(res, errorMessages.toString());
    }
}
