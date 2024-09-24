package ReadingStrategy;

import domain.Thing;

// this strategy intended to be used by "fillers"

// get info getNeededFieds(), prepare field content from input, 
// organize it into array in order corresponding to getNeededFields()
// then pass it to validate(), if successful then pass it to createThing().
// Fresh baked Thing object add to collection and cycle again
public abstract class BaseReadingStrategy {

    abstract public FieldDescription[] getNeededFields();

    // the order of input fields SHOULD be the same as in getNeededFields
    abstract public Thing createThing(String[] inputfields);

    // the order of input fields SHOULD be the same as in getNeededFields
	abstract public boolean validate(String[] inputfields);

}
