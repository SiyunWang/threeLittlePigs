package com.company;
public class Material {
    private String type;
    private int durability;
    private int timeToBuild;
    public int getTimeToBuild() {
        return timeToBuild;
    }
    public void setTimeToBuild(int timeToBuild) {
        this.timeToBuild = timeToBuild;
    }
    public Material (String type, int durability, int timeToBuild) {
        this.type = type;
        this.durability = durability;
        this.timeToBuild = timeToBuild;
    }
    public String getType() {
        return type;
    }
    public int getDurability() {
        return durability;
    }
}