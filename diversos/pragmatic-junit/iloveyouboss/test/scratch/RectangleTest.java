package scratch;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static scratch.ConstrainsSidesTo.constrainsSidesTo;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

public class RectangleTest {

  private Rectangle rectangle;

  @After
  public void ensureInvariant() {
    assertThat(this.rectangle, constrainsSidesTo(100));
  }

  @Test
  public void answersArea() {
    this.rectangle = new Rectangle(new Point(5, 5), new Point(15, 10));

    assertThat(this.rectangle.area(), equalTo(50));
  }

  @Test
  @Ignore("example of error")
  public void allowsDynamicallyChangingSize() {
    this.rectangle = new Rectangle(new Point(5, 5));
    this.rectangle.setOppositeCorner(new Point(130, 130));

    assertThat(this.rectangle.area(), equalTo(15625));
  }
}
