package domain;

import java.util.Comparator;

public class Vegetable extends Thing implements Comparable<Vegetable> {
    private int weight;
    private String color;

    public Vegetable(String name) {
        super(name);
    }

    public Vegetable(String name, int weight, String color) {
        super(name);
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

    public int compareTo(Vegetable vegetable) {
        return Comparator.comparing(Vegetable::getWeight)
                .thenComparing(Vegetable::getColor)
                .thenComparing(Vegetable::getName)
                .compare(this, vegetable);
    }

}
