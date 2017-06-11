package com.github.mdssjc.dogdoors;

import java.util.Iterator;

public class BarkRecognizer {

  private final DogDoor door;
  private final BarkManager manager;

  public BarkRecognizer(final DogDoor door, final BarkManager manager) {
    this.door = door;
    this.manager = manager;
  }

  public void recognize(final Bark bark) {
    System.out.println("BarkRecognizer: Heard a '" + bark.getSound() + "'");

    final Iterator<Bark> barks = this.manager.getAllowedBarks();
    while (barks.hasNext()) {
      final Bark allowedBark = barks.next();
      if (allowedBark.equals(bark)) {
        this.door.open();
        return;
      }
    }

    System.out.println("This dog is not allowed.");
  }
}
