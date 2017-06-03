package com.github.mdssjc.dogdoors;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BarkTest {

  private Bark bark;

  @Before
  public void setup() {
    this.bark = new Bark("Woof");
  }

  @Test
  public void compareTwoBarksEquals() {
    final Bark otherBark = new Bark("Woof");

    final boolean result = this.bark.equals(otherBark);

    assertTrue(result);
  }

  @Test
  public void compareTwoBarksEqualsInSound() {
    final Bark otherBark = new Bark("woof");

    final boolean result = this.bark.equals(otherBark);

    assertTrue(result);
  }

  @Test
  public void compareTwoBarksDifferent() {
    final Bark otherBark = new Bark("Yip! Yip!");

    final boolean result = this.bark.equals(otherBark);

    assertFalse(result);
  }
}
