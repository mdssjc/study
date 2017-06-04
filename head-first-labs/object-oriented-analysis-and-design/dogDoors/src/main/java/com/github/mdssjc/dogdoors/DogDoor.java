package com.github.mdssjc.dogdoors;

import java.util.*;

public class DogDoor {

  private static final long DELAY = 5000L;

  private final List<Bark> allowedBarks;
  private boolean open;

  public DogDoor() {
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
    }, DELAY);
  }

  public void close() {
    System.out.println("The dog door closes.");
    this.open = false;
  }

  public boolean isOpen() {
    return this.open;
  }

  public Iterator<Bark> getAllowedBarks() {
    return this.allowedBarks.iterator();
  }

  public void addAllowedBark(final Bark allowedBark) {
    this.allowedBarks.add(allowedBark);
  }
}
