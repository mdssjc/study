package scratch;

public class Bearing {

  public static final int MAX = 359;
  private final int       value;

  public Bearing(final int value) throws BearingOutOfRangeException {
    if (value < 0 || value > Bearing.MAX) {
      throw new BearingOutOfRangeException();
    }
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public int angleBetween(final Bearing bearing) {
    return this.value - bearing.value;
  }
}
