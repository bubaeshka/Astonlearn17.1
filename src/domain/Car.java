package domain;


import java.util.Comparator;



public class Car extends Thing implements Comparable<Car> {

    private int madeYear;

    private int power;

    public Car(String name) {
        super(name);
    }


    //приватный конструктор Car
    private Car(CarBuilder carBuilder){
        super(carBuilder.nameModel);
        this.madeYear = carBuilder.madeYear;
        this.power = carBuilder.power;
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

    //билдер Car
    static class CarBuilder{
        private final String nameModel;
        private int madeYear;
        private int power;

        public CarBuilder(String nameModel){
            this.nameModel = nameModel;
        }
        public CarBuilder setMadeYear(int madeYear){
            this.madeYear = madeYear;
            return this;
        }
        public CarBuilder setPower(int power){
            this.power = power;
            return this;
        }
        public Car build(){
            return new Car(this);
        }
    }


    @Override
    public int compareTo(Car car) {
        return Comparator.comparing(Car::getPower)
                .thenComparing(Car::getMadeYear)
                .thenComparing(Car::getName)
                .compare(this, car);
        }

    @Override
    public String toString() {
        return "Car{" +
                "name='"+ super.getName() + '\'' +
                ", power=" + power +
                ", madeYear='" + madeYear + '\'' +
                '}';
    }

}

