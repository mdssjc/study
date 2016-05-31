package com.github.mdssjc.ats.identifier;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class IdentifierTestCase {

  private Identifier       identifier;
  private static final int LIMIT = 200;

  @Before
  public void init() {
    this.identifier = new Identifier();
  }

  @Test(timeout = LIMIT)
  public void validate01() {
    final boolean obtido = this.identifier.validateIdentifier("a1");

    assertTrue(obtido);
  }

  @Test(timeout = 200)
  public void validate02() {
    final boolean obtido = this.identifier.validateIdentifier("");

    assertFalse(obtido);
  }

  @Test(timeout = 200)
  public void validate03() {
    final boolean obtido = this.identifier.validateIdentifier("A1b2C3d");

    assertFalse(obtido);
  }

  @Test(timeout = 200)
  public void validate04() {
    final boolean obtido = this.identifier.validateIdentifier("2B3");

    assertFalse(obtido);
  }

  @Test(timeout = 200)
  public void validate05() {
    final boolean obtido = this.identifier.validateIdentifier("Z#12");

    assertFalse(obtido);
  }
}
