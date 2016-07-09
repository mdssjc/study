package com.github.mdssjc.hfooad.dogdoors;

/**
 * This class represents the bark recognizer that opens the device it
 * controls if presented with a known bark.
 * 
 * @author mdssjc
 */
public class BarkRecognizer {

  private final DogDoor door;

  /**
   * Constructor initializes this recognizer by storing the device it
   * controls and the bark it recognizes.
   * 
   * @param door
   *          Door the recognizer controls
   */
  public BarkRecognizer(final DogDoor door) {
    this.door = door;
  }

  /**
   * The method enabling the recognizer to detect a bark.
   * 
   * @param bark
   *          A known bark
   */
  public void recognize(final Bark bark) {
    System.out.println("BarkRecognizer: Heard a '" + bark.getSound() + "'");
    if (this.door.getAllowedBark()
                 .equals(bark)) {
      this.door.open();
    } else {
      System.out.println("This dog is not allowed.");
    }
  }
}
