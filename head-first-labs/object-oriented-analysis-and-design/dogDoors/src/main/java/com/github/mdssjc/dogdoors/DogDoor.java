package com.github.mdssjc.dogdoors;

import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {

  private static final long DELAY = 5000L;

  private boolean open;

  public DogDoor() {
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
    }, DELAY);
  }

  public void close() {
    System.out.println("The dog door closes.");
    this.open = false;
  }

  public boolean isOpen() {
    return this.open;
  }
}
