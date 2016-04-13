package scratch;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class ConstrainsSidesTo extends TypeSafeMatcher<Rectangle> {

  private final int length;

  public ConstrainsSidesTo(final int length) {
    this.length = length;
  }

  @Override
  public void describeTo(final Description description) {
    description.appendText("both sides must be <= " + this.length);
  }

  @Override
  protected boolean matchesSafely(final Rectangle rect) {
    return Math.abs(rect.origin().x - rect.opposite().x) <= this.length &&
        Math.abs(rect.origin().y - rect.opposite().y) <= this.length;
  }

  @Factory
  public static <T> Matcher<Rectangle> constrainsSidesTo(final int length) {
    return new ConstrainsSidesTo(length);
  }
}
