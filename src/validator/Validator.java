package validator;

public class Validator {

    public boolean validData(String string) {
        String[] split = string.split(" ");
        if (split.length < 3) {
            return false;
        }
        for (String s : split) {
            if (!isLetters(s)) {
                if (!isDigits(s)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isLetters(String str) {
        if (str.matches("[a-zA-Z]+")) {
            if (!str.isEmpty() && !str.equals("null")) {
                return true;
            }
        }
        return false;
    }



    private boolean isDigits(String str) {
        int number;
        if (str.matches("[0-9]+")) {
            number = Integer.parseInt(str);
            if (number > 0 && number < 1000000)
                return true;
        }
        return false;
    }

}
