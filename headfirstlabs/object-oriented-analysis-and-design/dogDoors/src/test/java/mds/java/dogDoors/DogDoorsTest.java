package mds.java.dogDoors;

import org.junit.Before;
import org.junit.Test;

import mds.java.dogDoors.base.DogDoor;
import mds.java.dogDoors.base.Remote;

/**
 * @author mdssjc
 * 
 *         Dog Door Simulator
 *         level: System
 *
 */
public class DogDoorsTest {

    private static final int SLEEP = 10000;
    private Remote           remote;
    private DogDoor          door;

    @Before
    public void init() {
        door = new DogDoor();
        remote = new Remote(door);
    }

    @Test
    public void mainPath() {
        System.out.println("\nFido starts barking...");
        remote.pressButton();
        System.out.println("\nFido has gone outside...");
        System.out.println("\nFido's all done...");
    }

    @Test
    public void alternatePath() {
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
