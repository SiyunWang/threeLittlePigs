package com.company;
public class Wolf extends Character {
    public Wolf(String name, boolean isKind) {
        super(name, isKind);
    }
    public void walkTo() {
        setLocation(getLocation() + 1);
        System.out.println("The wolf is at location " + getLocation());
    }
    public void walkTo(int location) {
        setLocation(location);
        System.out.println("The wolf is at " + Story.pigs.get(location).getName() + "'s house.");
    }
    public void knock (int houseIndex) {
        System.out.println("Wolf is knocking on " + Story.pigs.get(location).getName() + "'s door.");
        System.out.println("Wolf yells 'Open up! Or I will huff and puff and blow your house in.' ");
    }
    public void blowOnTheHouse (int houseIndex) {
        // check the material
        // if the material is straw or wood
        // blows the house down -> changes the property in the house
        if (Story.houses.get(houseIndex).getMaterial().getDurability() < 3) {
            Story.houses.get(houseIndex).setBlownDown(true);
            System.out.println("The wolf huff and puff and blew " + Story.pigs.get(houseIndex).getName() + "'s house down");
        } else {
            System.out.println("The wolf huff and puff and couldn't blow " + Story.pigs.get(houseIndex).getName() + "'s house down");
        }
    }

    public void enterFromChimney (int houseIndex) {
        System.out.println("Wolf climbs to the roof, and tries to enter from the chimney.");
    }
}