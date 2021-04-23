package com.company;
public class Pig extends Character{
    private int age;
    public Pig(String name, boolean isKind, int age) {
        super(name, isKind);
        this.age = age;
        Story.pigs.add(this);
        System.out.println(name + " says, 'Hello World!'");
    }
    public void buildHouse(Material material) {
        House myHouse = new House(material, name);
        Story.houses.add(myHouse);
        Story.pigsHouses.put(this, myHouse);
        location = Story.houses.indexOf(myHouse);
        System.out.println(name + " has begun building their house from " + material.getType());
    }
    public void play() {
        String[] games = {"basketball", "board games", "piano", "in the pig sty", "soccer"};
        System.out.println(name + " is playing " + games[(int) (Math.random() * games.length)]);
    }
    public void runningToNextHouse(String runningPigs) {
        location++;
        String nextPigName = Story.houses.get(location).getBuilder();
        System.out.println(runningPigs + " successfully made it to " + nextPigName + "'s house");
    }

    public void response() {
        System.out.println(name + " says: 'You will never blow down my " + Story.pigsHouses.get(this).getMaterial().getType() + " house!' ");
    }

    public void startFire() {
        System.out.println(name + " starts a fire in the fireplace to scare the wolf away");
    }
}