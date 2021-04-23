package com.company;
public class House {
    private Material material;
    private boolean isBlownDown = false;
    private String builder;
    private boolean isComplete = false;
    public boolean isComplete() {
        return isComplete;
    }
    public void setComplete(boolean complete) {
        isComplete = complete;
    }
    public void setMaterial(Material material) {
        this.material = material;
    }
    public boolean getIsBlownDown() {
        return isBlownDown;
    }
    public Material getMaterial() {
        return material;
    }
    public String getBuilder() {
        return builder;
    }
    public void setBlownDown(boolean blownDown) {
        isBlownDown = blownDown;
    }
    public House (Material material, String builder) {
        this.material = material;
        this.builder = builder;
    }
}