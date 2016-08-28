package com.github.mdssjc.gsf.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UnitTest {

  @Test
  public void setAndGetACommonProperty() {
    final Unit unit = new Unit(0);
    unit.setProperty("type", "infantry");

    final Object output = unit.getProperty("type");

    assertEquals("infantry", output);
  }

  @Test
  public void setAndGetASpecificProperty() {
    Unit unit = new Unit(0);
    unit.setProperty("hitPoints", "25");

    Object output = unit.getProperty("hitPoints");

    assertEquals("25", output);
  }
}
