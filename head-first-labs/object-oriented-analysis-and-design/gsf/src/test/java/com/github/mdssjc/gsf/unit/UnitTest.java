package com.github.mdssjc.gsf.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UnitTest {

  @Test
  public void setAndGetACommonProperty() {
    final Unit unit = new Unit(0);
    final String property = "type";
    unit.setProperty(property, "infantry");

    final Object output = unit.getProperty(property);

    assertEquals("infantry", output);
  }

  @Test
  public void setAndGetASpecificProperty() {
    final Unit unit = new Unit(0);
    final String property = "hitPoints";
    unit.setProperty(property, "25");

    final Object output = unit.getProperty(property);

    assertEquals("25", output);
  }
}
