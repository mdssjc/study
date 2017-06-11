package com.github.mdssjc.dogdoors;

public class DogDoorsSimulator {

  public static void main(final String[] args) {
    final DogDoor door = new DogDoor();
    final BarkManager manager = new BarkManager();
    manager.addAllowedBark(new Bark("rowlf"));
    manager.addAllowedBark(new Bark("rooowlf"));
    manager.addAllowedBark(new Bark("rawlf"));
    manager.addAllowedBark(new Bark("woof"));
    final BarkRecognizer recognizer = new BarkRecognizer(door, manager);
    final Remote remote = new Remote(door);

    // Simulate the hardware hearing a bark
    System.out.println("Bruce starts barking.");
    recognizer.recognize(new Bark("rowlf"));

    System.out.println("\nBruce has gone outside...");

    sleep(10000);

    System.out.println("\nBruce’s all done...");
    System.out.println("...but he’s stuck outside!");

    // Simulate the hardware hearing a bark (not Bruce!)
    final Bark smallDogBark = new Bark("yip");
    System.out.println("A small dog starts barking.");
    recognizer.recognize(smallDogBark);

    sleep(5000);

    // Simulate the hardware hearing a bark again
    System.out.println("Bruce starts barking.");
    recognizer.recognize(new Bark("rooowlf"));

    System.out.println("\nBruce’s back inside...");
  }

  private static void sleep(final int ms) {
    try {
      Thread.currentThread()
            .sleep(ms);
    } catch (final InterruptedException e) {
      System.err.println(e.getMessage());
    }
  }
}
