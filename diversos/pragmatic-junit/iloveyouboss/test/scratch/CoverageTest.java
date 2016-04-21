package scratch;

import org.junit.Test;

public class CoverageTest {

  @Test
  public void noIncrementOfCount() {
    new Coverage().soleMethod();
  }

  @Test
  public void incrementOfCount() {
    final Coverage c = new Coverage();
    c.setCount(1);
    c.soleMethod();
  }
}
