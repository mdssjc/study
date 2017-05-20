package com.github.mdssjc.dogdoors;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {

  private final List<Bark> allowedBarks;
  private boolean open;

  public DogDoor() {
    this.open = false;
    this.allowedBarks = new ArrayList<>();
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

  public List<Bark> getAllowedBarks() {
    return this.allowedBarks;
  }

  public void addAllowedBark(final Bark allowedBark) {
    this.allowedBarks.add(allowedBark);
  }
}
