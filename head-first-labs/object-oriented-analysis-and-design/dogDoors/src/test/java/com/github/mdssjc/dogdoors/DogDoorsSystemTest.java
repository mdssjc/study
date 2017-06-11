package com.github.mdssjc.dogdoors;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DogDoorsSystemTest {

  private static final long SLEEP = 10000L;

  private Remote remote;
  private DogDoor door;

  @Before
  public void init() {
    this.door = new DogDoor();
  }

  @Test
  public void remoteInSimplePath() {
    this.remote = new Remote(this.door);

    this.remote.pressButton();
    final boolean result = this.door.isOpen();

    assertTrue(result);
  }

  @Test
  public void remoteInCompletePath() {
    this.remote = new Remote(this.door);

    this.remote.pressButton();
    final boolean result1 = this.door.isOpen();

    sleep();
    final boolean result2 = this.door.isOpen();

    this.remote.pressButton();
    final boolean result3 = this.door.isOpen();

    assertTrue(result1);
    assertFalse(result2);
    assertTrue(result3);
  }

  @Test
  public void recognizerAnAllowedBark() {
    final Bark allowedBark = new Bark("Woof");
    final BarkManager manager = new BarkManager();
    manager.addAllowedBark(allowedBark);
    final BarkRecognizer recognizer = new BarkRecognizer(this.door, manager);

    recognizer.recognize(allowedBark);
    final boolean result1 = this.door.isOpen();

    sleep();
    final boolean result2 = this.door.isOpen();

    recognizer.recognize(allowedBark);
    final boolean result3 = this.door.isOpen();

    assertTrue(result1);
    assertFalse(result2);
    assertTrue(result3);
  }

  @Test
  public void recognizerAnUnallowedBark() {
    final Bark allowedBark = new Bark("Woof");
    final BarkManager manager = new BarkManager();
    manager.addAllowedBark(allowedBark);
    final BarkRecognizer recognizer = new BarkRecognizer(this.door, manager);

    recognizer.recognize(new Bark("yep"));
    final boolean result = this.door.isOpen();

    assertFalse(result);
  }

  private void sleep() {
    try {
      Thread.sleep(DogDoorsSystemTest.SLEEP);
    } catch (final InterruptedException e) {
      System.err.println(e.getMessage());
    }
  }
}
