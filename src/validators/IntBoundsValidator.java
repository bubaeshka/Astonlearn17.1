package validators;

public class IntBoundsValidator extends BaseValidator {
    private final int min, max;

    public IntBoundsValidator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    @Override
    public ValidationResult validate(String s) {
        //затычка для переменных полей
        if (s==null)
            return new ValidationResult(true, "");
        int val;
        try {
            val = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return new ValidationResult(false, "ошибка формата числа");
        }
        if (val < min || val > max)
            return new ValidationResult(false, "значение вышло за допустимые границы от " + min + " до " + max);

        return new ValidationResult(true, "");
    }

}