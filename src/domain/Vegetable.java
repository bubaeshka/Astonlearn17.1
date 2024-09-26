package domain;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


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
    private Vegetable(Builder vegetableBuilder) {
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
    public static class Builder {
        private final String typeName;
        private int weight;
        private String color;

        public Builder(String typeName) {
            this.typeName = typeName;
        }

        public Builder setWeight(int weight) {
            this.weight = weight;
            return this;
        }
        public Builder setColor(String color) {
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
	public Map<String, String> getHumanReadableFieldMap(){
		var res = new HashMap<String, String>();
		res.put("name", "вид");
		res.put("weight", "вес");
		res.put("color", "цвет");
		return res;
	}


    @Override
    public String toString() {
        return "Vegetable{" +
                "Type=" + super.getName() +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }

}

