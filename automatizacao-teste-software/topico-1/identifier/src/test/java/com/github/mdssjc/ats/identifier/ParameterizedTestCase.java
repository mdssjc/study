package com.github.mdssjc.ats.identifier;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTestCase {

  private Identifier    identifier;

  private final String  param;
  private final boolean result;

  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
        { "Abcd5", true },
        { "&123", false },
        { "Inv@lido", false }
    });
  }

  public ParameterizedTestCase(final String param, final boolean result) {
    this.param = param;
    this.result = result;
  }

  @Before
  public void init() {
    this.identifier = new Identifier();
  }

  @Test(timeout = 200)
  public void validate() {
    final boolean value = this.identifier.validateIdentifier(this.param);

    assertEquals(this.result, value);
  }
}
