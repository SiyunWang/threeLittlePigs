package com.company;
public class Character {
    protected String name;
    protected boolean isKind;
    protected int location = -1;
    public Character(String name, boolean isKind) {
        this.name = name;
        this.isKind = isKind;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLocation() {
        return location;
    }
    public void setLocation(int location) {
        this.location = location;
    }
}