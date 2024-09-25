package domain;

public class Vegetable extends Thing {
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


    /*
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

     */
 


    public int compareTo(Thing o) {
        return (this.weight - ((Vegetable)o).getWeight());
    }

    @Override
    public int compare(Thing o1, Thing o2) {
        return 0;
    }


    @Override
    public String toString() {
        return "Vegetable{" +
                "Type=" + super.getName() +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }

    //билдер Vegetable
    public static class VegetableBuilder {
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
}

