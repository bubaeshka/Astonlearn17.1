package domain;

import java.util.Comparator;

public class Car implements Comparable<Car> , Comparator {
    private String modelName;
    private int madeYear;
    private int power;


    public Car(String modelName, int madeYear, int power) {
        this.modelName = modelName;
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
        return (this.power - car.power);
    }

    @Override
    public String toString() {
        return "Car{" +
                "modelName='" + modelName + '\'' +
                ", madeYear=" + madeYear +
                ", power=" + power +
                '}';
    }



    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
