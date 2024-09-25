package domain;


import java.util.Comparator;



public class Car extends Thing {


    private int madeYear;

    private int power;

    public Car(String name) {
        super(name);
    }

//    public Car(String name, int madeYear, int power) {
//        super(name);
//        this.madeYear = madeYear;
//        this.power = power;
//    }

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

    /*
    @Override
    public int compareTo(Car car) {
        return Comparator.comparing(Car::getMadeYear)
                .thenComparing(Car::getPower)
                .thenComparing(Car::getName)
                .compare(this, car);
    }

}

    public int compareTo(Car o) {
        int t=name.compareTo(o.name);
        if (t!=0)return t;
        t=madeYear-o.madeYear;
        if (t!=0)return t;
        t=power-o.power;
        if (t!=0)return t;
        return 0;
    }

     */

    @Override
    public String toString() {
        return "Car [name=" + super.getName() + ", madeYear=" + madeYear + ", power=" + power + "]";
    }

    public int compareTo(Thing o) {
        return (this.power-((Car)o).getPower());
    }

    @Override
    public int compare(Thing o1, Thing o2) {
        return 0;

    }

    //билдер Car
    public static class CarBuilder{
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
}

