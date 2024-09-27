package domain;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;



public class Car extends Thing implements Comparable<Car> {

    private int madeYear;

    private int power;

    public Car(String name) {
        super(name);
    }


    //приватный конструктор Car
    private Car(Builder carBuilder){
        super(carBuilder.nameModel);
        this.madeYear = carBuilder.madeYear;
        this.power = carBuilder.power;
    }

    public void setMadeYear(int madeYear) {
        this.madeYear = madeYear;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getMadeYear() {
        return madeYear;
    }

    public int getPower() {
        return power;
    }

    //билдер Car
    public static class Builder{
        private final String nameModel;
        private int madeYear;
        private int power;

        public Builder(String nameModel){
            this.nameModel = nameModel;
        }
        public Builder setMadeYear(int madeYear){
            this.madeYear = madeYear;
            return this;
        }
        public Builder setPower(int power){
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

    public Map<String, String> getHumanReadableFieldMap(){
		var res = new HashMap<String, String>();
		res.put("name","модель");
		res.put("madeYear","год выпуска ");
		res.put("power","мощность");
		return res;
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

