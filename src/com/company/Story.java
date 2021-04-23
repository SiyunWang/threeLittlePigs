package com.company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Story {
    public static ArrayList<House> houses = new ArrayList<>();
    public static ArrayList<Pig> pigs = new ArrayList<>();
    public static HashMap<Pig, House> pigsHouses = new HashMap<>();
    public static Scanner scanner = new Scanner(System.in);
    public static int currentDay = 0;
    public static String[] materialsUsed = {"straw", "wood", "brick"};
    public static int[] timeToBuild = {1, 3, 7};
    public void intro() {
        System.out.println("Welcome to the Three Little Pigs Story.");
        System.out.println("Meet the 3 little pigs:");
        Pig pig1 = new Pig("pig1", true, 15);
        Pig pig2 = new Pig("pig2", true, 17);
        Pig pig3 = new Pig("pig3", true, 19);
        System.out.println("We are on the morning of day " + currentDay +
                ". Please press ENTER to get started with the story.");
        scanner.nextLine();
    }
    public void buildingHouses () {
        for (int i = 0; i < pigs.size(); i++) {
            pigs.get(i).buildHouse(new Material(materialsUsed[i], (i + 1), timeToBuild[i]));
        }
        System.out.println("Please press ENTER to continue the story to Day 1.");
        currentDay++;
        scanner.nextLine();
        while (currentDay < 8) {
            for (Pig pig: pigs) {
                if (pigsHouses.get(pig).getMaterial().getTimeToBuild() == currentDay) {
                    pigsHouses.get(pig).setComplete(true);
                    System.out.println(pig.getName() + " has finished building its house.");
                } else if (pigsHouses.get(pig).isComplete()){
                    pig.play();
                } else {
                    System.out.println(pig.getName() + " is still working on its house.");
                }
            }
            currentDay++;
            System.out.println("Please press ENTER to continue to day " + currentDay + ".");
            scanner.nextLine();
        }
    }
    public void wolfAttack () {
        System.out.println("All the pigs have finished building their houses. On the 8th day a wolf approaches...");
        System.out.println("Please press ENTER to continue the story.");
        scanner.nextLine();
        Wolf wolf = new Wolf("wolf", false);
        for (int i = 0; i < pigs.size(); i++) {
            wolf.walkTo(i);
            wolf.knock(i);
            System.out.println("press enter to see what " + pigs.get(i).getName() + " says.");
            scanner.nextLine();
            // pig response
            pigs.get(i).response();
            wolf.blowOnTheHouse(i);
            // if house is blown down
            System.out.println("press enter to see what happens next");
            scanner.nextLine();
            if (pigsHouses.get(pigs.get(i)).getIsBlownDown()) {
                String runningPigs = "";
                for (Pig pig : pigs) {
                    if (pig.getLocation() == i) {
                        if (runningPigs.isEmpty()) {
                            runningPigs += pig.getName();
                        } else {
                            runningPigs += " and " + pig.getName();
                        }
                    }
                }
                // pig runs
                pigs.get(i).runningToNextHouse(runningPigs);
            } else {
                wolf.enterFromChimney(i);
                pigs.get(i).startFire();
                System.out.println("press enter to see what happens next");
                scanner.nextLine();
            }
        }
    }

    public void conclusion () {
        System.out.println("Three little pigs live happily ever after");
        System.out.println("THE END!");
    }
}