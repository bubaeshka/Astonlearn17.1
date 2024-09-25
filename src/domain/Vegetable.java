package domain;


import java.util.Comparator;


public class Vegetable extends Thing implements Comparable<Vegetable> {

    private int weight;
    private String color;

    public Vegetable(String name) {
        super(name);
    }

//    public Vegetable(String name, int weight, String color) {
//        super(name);
//        this.weight = weight;
//        this.color = color;
//    }

    //конструктор Vegetable
    private Vegetable(VegetableBuilder vegetableBuilder) {
        super(vegetableBuilder.typeName);
        this.weight = vegetableBuilder.weight;
        this.color = vegetableBuilder.color;
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //билдер Vegetable
    static class VegetableBuilder {
        private final String typeName;
        private int weight;
        private String color;

        public VegetableBuilder(String typeName) {
            this.typeName = typeName;
        }
        public VegetableBuilder setWeight(int weight) {
            this.weight = weight;
            return this;
        }
        public VegetableBuilder setColor(String color) {
            this.color = color;
            return this;
        }
        public Vegetable build() {
            return new Vegetable(this);
        }
    }


    public int compareTo(Vegetable vegetable) {
        return Comparator.comparing(Vegetable::getWeight)
                .thenComparing(Vegetable::getColor)
                .thenComparing(Vegetable::getName)
                .compare(this, vegetable);
    }

    @Override
    public String toString() {
        return "Vegetable{" +
                "Type=" + super.getName() +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }

}

