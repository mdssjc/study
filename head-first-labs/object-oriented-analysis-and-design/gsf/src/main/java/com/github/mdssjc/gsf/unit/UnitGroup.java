package com.github.mdssjc.gsf.unit;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UnitGroup {

  private final Map<Integer, Unit> units;

  public UnitGroup(final List<Unit> unitList) {
    this.units = new HashMap<>();
    for (final Unit unit : unitList) {
      this.units.put(unit.getId(), unit);
    }
  }

  public UnitGroup() {
    this(new LinkedList<>());
  }

  public void addUnit(final Unit unit) {
    this.units.put(unit.getId(), unit);
  }

  public void removeUnit(final int id) {
    this.units.remove(id);
  }

  public void removeUnit(final Unit unit) {
    removeUnit(unit.getId());
  }

  public Unit getUnit(final int id) {
    return this.units.get(id);
  }

  public List<Unit> getUnits() {
    return new LinkedList<>(this.units.values());
  }
}
