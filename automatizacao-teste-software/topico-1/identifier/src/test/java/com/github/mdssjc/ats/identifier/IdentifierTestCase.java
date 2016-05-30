package com.github.mdssjc.ats.identifier;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IdentifierTestCase {

  @Test
  public void validate01() {
    Identifier identifier = new Identifier();

    boolean obtido = identifier.validateIdentifier("a1");

    assertTrue(obtido);
  }

  @Test
  public void validate02() {
    Identifier identifier = new Identifier();

    boolean obtido = identifier.validateIdentifier("");

    assertFalse(obtido);
  }

  @Test
  public void validate03() {
    Identifier identifier = new Identifier();

    boolean obtido = identifier.validateIdentifier("A1b2C3d");

    assertFalse(obtido);
  }

  @Test
  public void validate04() {
    Identifier identifier = new Identifier();

    boolean obtido = identifier.validateIdentifier("2B3");

    assertFalse(obtido);
  }

  @Test
  public void validate05() {
    Identifier identifier = new Identifier();

    boolean obtido = identifier.validateIdentifier("Z#12");

    assertFalse(obtido);
  }
}
