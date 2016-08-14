package com.github.mdssjc.gsf.board;

import java.util.LinkedList;
import java.util.List;

import com.github.mdssjc.gsf.unit.Unit;

public class Tile {

  private final List<Unit> units;

  public Tile() {
    this.units = new LinkedList<>();
  }

  public List<Unit> getUnits() {
    return this.units;
  }

  protected void addUnit(final Unit unit) {
    this.units.add(unit);
  }

  protected void removeUnit(final Unit unit) {
    this.units.remove(unit);
  }

  public void removeUnits() {
    this.units.clear();
  }
}
