package scratch;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class NewtonTest {

  static class Newton {

    public static final double TOLERANCE = 1E-16;

    public static double squareRoot(final double n) {
      double approx = n;
      while (Math.abs(approx - n / approx) > Newton.TOLERANCE * approx) {
        approx = (n / approx + approx) / 2.0;
      }
      return approx;
    }
  }

  @Test
  public void squareRoot() {
    final double result = Newton.squareRoot(250.0);

    assertThat(result * result, closeTo(250.0, Newton.TOLERANCE));
  }
}
