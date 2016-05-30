package com.github.mdssjc.ats.identifier;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class IdentifierTestCase {

  private Identifier identifier;

  @Before
  public void init() {
    identifier = new Identifier();
  }

  @Test
  public void validate01() {
    boolean obtido = identifier.validateIdentifier("a1");

    assertTrue(obtido);
  }

  @Test
  public void validate02() {
    boolean obtido = identifier.validateIdentifier("");

    assertFalse(obtido);
  }

  @Test
  public void validate03() {
    boolean obtido = identifier.validateIdentifier("A1b2C3d");

    assertFalse(obtido);
  }

  @Test
  public void validate04() {
    boolean obtido = identifier.validateIdentifier("2B3");

    assertFalse(obtido);
  }

  @Test
  public void validate05() {
    boolean obtido = identifier.validateIdentifier("Z#12");

    assertFalse(obtido);
  }
}
