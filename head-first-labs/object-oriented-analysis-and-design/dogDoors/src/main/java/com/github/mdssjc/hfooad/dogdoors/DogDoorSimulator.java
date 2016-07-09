package com.github.mdssjc.hfooad.dogdoors;

public class DogDoorSimulator {

  private static final int SLEEP = 10000;

  public static void main(final String[] args) {
    final DogDoor door = new DogDoor();
    final BarkRecognizer recognizer = new BarkRecognizer(door);

    System.out.println("\nFido starts barking.");
    recognizer.recognize("Woof");
    System.out.println("\nFido has gone outside...");
    System.out.println("\nFido's all done...");

    try {
      Thread.sleep(DogDoorSimulator.SLEEP);
    } catch (final InterruptedException e) {
      System.err.println(e.getMessage());
    }

    System.out.println("... but he's stuck outside!");
    System.out.println("\nFido starts barking...");
    recognizer.recognize("Woof");
    System.out.println("\nFido’s back inside...");
  }
}
