package domain;

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

    @Override
    public int compareTo(Vegetable o) {
		int t=name.compareTo(o.name);
		if (t!=0)return t;
		t=weight-o.weight;
		if (t!=0)return t;
		t=color.compareTo(o.color);
		if (t!=0)return t;
        return 0;
    }
 
}
