package domain;

public class Vegetable extends Thing{
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

    @Override
    public int compareTo(Object o) {
        return 0;
    }
 
}
