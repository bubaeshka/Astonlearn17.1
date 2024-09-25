package domain;

public abstract class Thing {

    private String name;
    //protected String name;


    public Thing(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Thing [name=" + name + "]";
    }


}
