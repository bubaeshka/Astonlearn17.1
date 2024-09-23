package domain;

import java.util.Comparator;

public abstract class Thing implements Comparable , Comparator {
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
}
