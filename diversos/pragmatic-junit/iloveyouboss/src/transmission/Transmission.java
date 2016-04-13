package transmission;

public class Transmission {

  private Gear           gear;
  private final Moveable moveable;

  public Transmission(final Moveable moveable) {
    this.moveable = moveable;
  }

  public void shift(final Gear gear) {
    // begs for a state-machine implementation
    if (this.moveable.currentSpeedInMph() > 0 && gear == Gear.PARK) {
      return;
    }
    this.gear = gear;
  }

  public Gear getGear() {
    return this.gear;
  }
}
