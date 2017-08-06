package com.github.mdssjc.gsf.util;

import com.github.mdssjc.gsf.board.Coordinate;
import com.github.mdssjc.gsf.unit.Unit;

import java.util.HashMap;
import java.util.Map;

public class UnitBoardAssociation {

  private final Map<Unit, Coordinate> unitBoardMap;

  public UnitBoardAssociation() {
    this.unitBoardMap = new HashMap<>();
  }

  public void associate(final Unit unit, final Coordinate coordinate) {
    this.unitBoardMap.put(unit, coordinate);
  }

  public void removeAssociation(final Unit unit) {
    this.unitBoardMap.remove(unit);
  }

  public Coordinate getCoordinate(final Unit unit) {
    return this.unitBoardMap.get(unit);
  }
}
