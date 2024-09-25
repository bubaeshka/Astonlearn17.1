package domain;

    

public abstract class Thing implements Comparable <Thing> , Comparator <Thing> {
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

    /*
    public int compareTo(Thing o) {
        return 0;
    }


    public int compare(Thing o1, Thing o2) {
        return 0;
    }

     */

}
