package com.github.mdssjc.hfooad.dogdoors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class DogDoorsSystemTest {

  private static final int SLEEP = 10000;

  private Remote  remote;
  private DogDoor door;

  @Before
  public void init() {
    this.door = new DogDoor();
    this.door.addAllowedBark(new Bark("Woof"));
    this.remote = new Remote(this.door);
  }

  @Test
  public void simplePath() {
    System.out.println("\nFido starts barking...");
    this.remote.pressButton();
    assertTrue(this.door.isOpen());
    System.out.println("\nFido has gone outside...");
    System.out.println("\nFido's all done...");
  }

  @Test
  public void remotePath() {
    System.out.println("\nFido starts barking...");
    this.remote.pressButton();
    assertTrue(this.door.isOpen());
    System.out.println("\nFido has gone outside...");
    System.out.println("\nFido's all done...");

    sleep();

    assertFalse(this.door.isOpen());
    System.out.println("... but he's stuck outside!");
    System.out.println("\nFido starts barking...");
    System.out.println("...so Gina grabs the remote control.");
    this.remote.pressButton();
    assertTrue(this.door.isOpen());
    System.out.println("\nFido’s back inside...");
  }

  @Test
  public void recognizerPath() {
    final BarkRecognizer recognizer = new BarkRecognizer(this.door);

    System.out.println("\nFido starts barking.");
    recognizer.recognize(new Bark("Woof"));
    assertTrue(this.door.isOpen());
    System.out.println("\nFido has gone outside...");
    System.out.println("\nFido's all done...");

    sleep();

    assertFalse(this.door.isOpen());
    System.out.println("... but he's stuck outside!");
    System.out.println("\nFido starts barking...");
    recognizer.recognize(new Bark("Woof"));
    assertTrue(this.door.isOpen());
    System.out.println("\nFido’s back inside...");
  }

  private void sleep() {
    try {
      Thread.sleep(DogDoorsSystemTest.SLEEP);
    } catch (final InterruptedException e) {
      System.err.println(e.getMessage());
    }
  }
}
