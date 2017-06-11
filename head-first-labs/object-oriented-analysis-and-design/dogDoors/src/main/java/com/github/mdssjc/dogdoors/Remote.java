package com.github.mdssjc.dogdoors;

import java.util.LinkedList;
import java.util.List;

public class Remote {

  private final List<DogDoor> doors;

  public Remote(final DogDoor door) {
    this.doors = new LinkedList<>();
    this.doors.add(door);
  }

  private static void accept(final DogDoor door) {
    if (door.isOpen()) {
      door.close();
    } else {
      door.open();
    }
  }

  public void pressButton() {
    System.out.println("Pressing the remote control button...");
    this.doors.forEach(Remote::accept);
  }
}
