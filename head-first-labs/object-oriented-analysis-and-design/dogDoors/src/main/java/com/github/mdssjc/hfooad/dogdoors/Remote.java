package com.github.mdssjc.hfooad.dogdoors;

public class Remote {

  private final DogDoor door;

  public Remote(final DogDoor door) {
    this.door = door;
  }

  public void pressButton() {
    System.out.println("Pressing the remote control button...");
    if (this.door.isOpen()) {
      this.door.close();
    } else {
      this.door.open();
    }
  }
}
