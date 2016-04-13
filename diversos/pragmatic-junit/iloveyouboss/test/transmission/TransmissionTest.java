package transmission;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TransmissionTest {

  private Transmission transmission;
  private Car          car;

  @Before
  public void create() {
    this.car = new Car();
    this.transmission = new Transmission(this.car);
  }

  @Test
  public void remainsInDriveAfterAcceleration() {
    this.transmission.shift(Gear.DRIVE);
    this.car.accelerateTo(35);

    assertThat(this.transmission.getGear(), equalTo(Gear.DRIVE));
  }

  @Test
  public void ignoresShiftToParkWhileInDrive() {
    this.transmission.shift(Gear.DRIVE);
    this.car.accelerateTo(30);

    this.transmission.shift(Gear.PARK);

    assertThat(this.transmission.getGear(), equalTo(Gear.DRIVE));
  }

  @Test
  public void allowsShiftToParkWhenNotMoving() {
    this.transmission.shift(Gear.DRIVE);
    this.car.accelerateTo(30);
    this.car.brakeToStop();

    this.transmission.shift(Gear.PARK);

    assertThat(this.transmission.getGear(), equalTo(Gear.PARK));
  }
}
