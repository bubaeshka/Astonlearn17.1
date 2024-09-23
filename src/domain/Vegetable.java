package domain;

import java.util.Comparator;

public class Vegetable implements Comparable <Vegetable>, Comparator {
    private String typeName;
    private int weight;
    private String color;



    public Vegetable(String typeName, int weight, String color) {
        this.typeName = typeName;
        this.weight = weight;
        this.color = color;
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


    @Override
    public int compareTo(Vegetable vegetable) {
        return (this.weight - vegetable.weight);
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public String toString() {
        return "Vegetable{" +
                "typeName='" + typeName + '\'' +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}
