package domain;

public class Car extends Thing {
    private int madeYear;
    private int power;

    public Car(String name) {
        super(name);
    }

    public Car(String name, int madeYear, int power) {
        super(name);
        this.madeYear = madeYear;
        this.power = power;
    }

    public int getMadeYear() {
        return madeYear;
    }

    public void setMadeYear(int madeYear) {
        this.madeYear = madeYear;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Car [name=" + name + ", madeYear=" + madeYear + ", power=" + power + "]";
    }
}
