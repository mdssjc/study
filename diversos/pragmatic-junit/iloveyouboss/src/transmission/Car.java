package transmission;

public class Car implements Moveable {

  private int mph;

  @Override
  public int currentSpeedInMph() {
    return this.mph;
  }

  public void accelerateTo(final int mph) {
    this.mph = mph;
  }

  public void brakeToStop() {
    this.mph = 0;
  }
}
