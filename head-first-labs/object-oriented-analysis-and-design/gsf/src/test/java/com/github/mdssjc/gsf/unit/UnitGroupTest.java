package com.github.mdssjc.gsf.unit;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UnitGroupTest {

  @Test
  public void CreatingANewUnitGroupFromAListOfUnits() {
    final UnitGroup unitGroup;
    final List<Unit> units = Arrays.asList(new Unit(0), new Unit(1),
                                           new Unit(2));

    unitGroup = new UnitGroup(units);
    final List<Unit> unitsOutput = unitGroup.getUnits();

    assertEquals(units, unitsOutput);
  }

  @Test
  public void AddingAUnitToAGroup() {
    final UnitGroup unitGroup = new UnitGroup();
    final Unit unit = new Unit(100);

    unitGroup.addUnit(unit);
    final Unit unitOutput = unitGroup.getUnit(100);

    assertEquals(unit, unitOutput);
  }

  @Test
  public void GettingAUnitByItsId() {
    final UnitGroup unitGroup = new UnitGroup();
    final int id = 100;

    final Unit unit = new Unit(id);
    unitGroup.addUnit(unit);
    final Unit unitOutput = unitGroup.getUnit(id);

    assertEquals(unit, unitOutput);
  }

  @Test
  public void GettingAllTheUnitsInAGroup() {
    final List<Unit> units = Arrays.asList(new Unit(0), new Unit(1),
                                           new Unit(2));
    final UnitGroup unitGroup = new UnitGroup(units);

    final List<Unit> unitsOutput = unitGroup.getUnits();

    assertEquals(units, unitsOutput);
  }

  @Test
  public void RemovingAUnitByTheIdOfTheUnit() {
    final UnitGroup unitGroup = new UnitGroup();
    final int id = 100;

    unitGroup.addUnit(new Unit(id));
    unitGroup.removeUnit(id);

    assertTrue(unitGroup.getUnits()
                        .isEmpty());
  }

  @Test
  public void RemovingAUnitByTheUnitInstance() {
    final UnitGroup unitGroup = new UnitGroup();
    final Unit unit = new Unit(100);

    unitGroup.addUnit(unit);
    unitGroup.removeUnit(unit);

    assertTrue(unitGroup.getUnits()
                        .isEmpty());
  }
}
