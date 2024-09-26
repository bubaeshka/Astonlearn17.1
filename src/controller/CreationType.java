package controller;

import java.util.ArrayList;

enum CreationType {
    MANUAL("Вручную"), FILE("Из файла"), RANDOM("Случайно");

    private final String name;
    private ArrayList<String> pseudonyms = new ArrayList<>();
    private void setPseudonym(String pseudonym) {this.pseudonyms.add(pseudonym);}

    private CreationType(String name) {
        this.name = name;
        setPseudonym(name);
        setPseudonym(String.valueOf(this.ordinal()+1));
        setPseudonym(this.ordinal()+1 + ". " + this.getName());
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getPseudonyms() {
        return pseudonyms;
    }
}