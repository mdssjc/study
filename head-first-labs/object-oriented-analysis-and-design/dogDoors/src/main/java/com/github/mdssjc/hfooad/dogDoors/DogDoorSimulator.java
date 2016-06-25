package com.github.mdssjc.hfooad.dogDoors;

public class DogDoorSimulator {

    private static final int SLEEP = 10000;

    public static void main(String[] args) {
        DogDoor door = new DogDoor();
        Remote remote = new Remote(door);

        System.out.println("\nFido starts barking...");
        remote.pressButton();
        System.out.println("\nFido has gone outside...");
        System.out.println("\nFido's all done...");

        try {
            Thread.sleep(SLEEP);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("... but he's stuck outside!");
        System.out.println("\nFido starts barking...");
        System.out.println("...so Gina grabs the remote control.");
        remote.pressButton();
        System.out.println("\nFido’s back inside...");
    }
}
