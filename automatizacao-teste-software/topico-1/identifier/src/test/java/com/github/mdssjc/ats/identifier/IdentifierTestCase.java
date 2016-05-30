package com.github.mdssjc.ats.identifier;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IdentifierTestCase {

  @Test
  public void validate01() {
    Identifier identifier = new Identifier();

    boolean obtido = identifier.validateIdentifier("a1");

    assertTrue(obtido);
  }
}
