package domain;

public class Car extends Thing {
    private  int madeYear;
    private int power;

    public Car(String name) {
        super(name);
    }

//    public Car(String name, int madeYear, int power) {
//        super(name);
//        this.madeYear = madeYear;
//        this.power = power;
//    }
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

    @Override
    public int compareTo(Object o) {
        return (this.power-((Car)o).getPower());
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public String toString() {
        return "Car{" +
                "modelName=" + super.getName()+
                ", madeYear=" + madeYear +
                ", power=" + power +
                '}';
    }

    public static class CarBuilder{
        private String nameModel;
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