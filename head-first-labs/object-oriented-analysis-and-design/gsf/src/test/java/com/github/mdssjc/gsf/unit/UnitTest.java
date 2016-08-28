package com.github.mdssjc.gsf.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class UnitTest {

  private Unit unit;

  @Before
  public void initialize() {
    this.unit = new Unit(0);
  }

  @Test
  public void settingAndGettingACommonProperty() {
    final String property = "type";
    this.unit.setProperty(property, "infantry");

    final Object output = this.unit.getProperty(property);

    assertEquals("infantry", output);
  }

  @Test
  public void settingAndGettingAUnitSpecificProperty() {
    final String property = "hitPoints";
    this.unit.setProperty(property, "25");

    final Object output = this.unit.getProperty(property);

    assertEquals("25", output);
  }

  @Test
  public void changingAnExistingPropertysValue() {
    final String property = "hitPoints";
    this.unit.setProperty(property, "25");

    this.unit.setProperty(property, "15");
    final Object output = this.unit.getProperty(property);

    assertEquals("15", output);
  }

  @Test
  public void gettingANonExistentPropertysValue() {
    final String property = "strength";

    final Object output = this.unit.getProperty(property);

    assertNull(output);
  }

  @Test
  public void addingAWeapon() {
    final Weapon weapon = new Weapon();

    this.unit.addWeapon(weapon);
    final List<Weapon> weapons = this.unit.getWeapons();

    assertSame(weapon, weapons.get(0));
  }
}
