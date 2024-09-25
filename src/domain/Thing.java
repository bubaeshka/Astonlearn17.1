package domain;

import java.util.Comparator;

public abstract class Thing implements Comparable <Thing> , Comparator <Thing> {
    private String name;

    public Thing(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
