package iloveyouboss;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ScoreCollectionTest {

  private ScoreCollection collection;

  @Before
  public void createCollection() {
    this.collection = new ScoreCollection();
  }

  @Test
  public void answersArithmeticMeanOfTwoNumbers() {
    this.collection.add(() -> 5);
    this.collection.add(() -> 7);

    final int actualResult = this.collection.arithmeticMean();

    assertThat(actualResult, equalTo(6));
  }

  @Test(expected = IllegalArgumentException.class)
  public void throwsExceptionWhenAddingNull() {
    this.collection.add(null);
  }

  @Test
  public void answersZeroWhenNoElementsAdded() {
    assertThat(this.collection.arithmeticMean(), equalTo(0));
  }

  // @Test
  // public void dealsWithIntegerOverflow() {
  // collection.add(() -> Integer.MAX_VALUE);
  // collection.add(() -> 1);
  //
  // assertThat(collection.arithmeticMean(), equalTo(1073741824));
  // }

  @Test
  public void doesNotProperlyHandleIntegerOverflow() {
    this.collection.add(() -> Integer.MAX_VALUE);
    this.collection.add(() -> 1);

    assertTrue(this.collection.arithmeticMean() < 0);
  }
}
