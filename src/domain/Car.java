package domain;

import java.util.Comparator;

public class Car extends Thing implements Comparable<Car> {
    private  int madeYear;
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
    public int compareTo(Car car) {
        return Comparator.comparing(Car::getMadeYear)
                .thenComparing(Car::getPower)
                .thenComparing(Car::getName)
                .compare(this, car);
    }

}
