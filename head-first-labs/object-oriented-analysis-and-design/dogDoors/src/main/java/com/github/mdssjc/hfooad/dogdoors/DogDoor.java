package com.github.mdssjc.hfooad.dogdoors;

import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {

  private boolean open;
  private Bark    allowedBark;

  public DogDoor() {
    this.open = false;
  }

  public void open() {
    System.out.println("The dog door opens.");
    this.open = true;

    final Timer timer = new Timer();
    timer.schedule(new TimerTask() {

      @Override
      public void run() {
        close();
        timer.cancel();
      }
    }, 5000);
  }

  public void close() {
    System.out.println("The dog door closes.");
    this.open = false;
  }

  public boolean isOpen() {
    return this.open;
  }

  public Bark getAllowedBark() {
    return this.allowedBark;
  }

  public void setAllowedBark(final Bark allowedBark) {
    this.allowedBark = allowedBark;
  }
}
