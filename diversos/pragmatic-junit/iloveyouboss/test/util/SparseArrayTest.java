package util;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class SparseArrayTest {

  private SparseArray<Object> array;

  @Before
  public void create() {
    this.array = new SparseArray<>();
  }

  @Test
  public void handlesInsertionInDescendingOrder() {
    this.array.put(7, "seven");
    this.array.checkInvariants();
    this.array.put(6, "six");
    this.array.checkInvariants();

    assertThat(this.array.get(6), equalTo("six"));
    assertThat(this.array.get(7), equalTo("seven"));
  }
}
