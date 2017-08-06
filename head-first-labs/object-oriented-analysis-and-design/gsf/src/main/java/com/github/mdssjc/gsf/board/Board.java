package com.github.mdssjc.gsf.board;

import com.github.mdssjc.gsf.unit.Unit;
import com.github.mdssjc.gsf.util.UnitBoardAssociation;

import java.util.ArrayList;
import java.util.List;

public class Board {

  private final int width;
  private final int height;
  private UnitBoardAssociation ubAssociation;
  private List<List<Tile>> tiles;

  public Board(final int width, final int height) {
    this.width = width;
    this.height = height;
    initialize();
  }

  private void initialize() {
    this.tiles = new ArrayList<>(this.width);
    for (int i = 0; i < this.width; i++) {
      this.tiles.add(i, new ArrayList<>(this.height));
      for (int j = 0; j < this.height; j++) {
        this.tiles.get(i)
                  .add(j, new Tile());
      }
    }
    this.ubAssociation = new UnitBoardAssociation();
  }

  public Tile getTile(final int posX, final int posY) {
    return this.tiles.get(posX - 1)
                     .get(posY - 1);
  }

  public Tile getTileAt(final Coordinate coordinate) {
    return this.tiles.get(coordinate.getX())
                     .get(coordinate.getY());
  }

  public void addUnit(final Unit unit, final int posX, final int posY) {
    final Tile tile = getTile(posX, posY);
    tile.addUnit(unit);
  }

  public void addUnit(final Unit u, final Coordinate coordinate) {
    getTileAt(coordinate).addUnit(u);
    this.ubAssociation.associate(u, coordinate);
  }

  public void moveUnit(final Unit unit, final Coordinate coordinate) {
    if (whereIs(unit) != null) {
      removeUnit(unit);
      addUnit(unit, coordinate);
    }
  }

  public void removeUnit(final Unit unit, final int posX, final int posY) {
    final Tile tile = getTile(posX, posY);
    tile.removeUnit(unit);
  }

  public void removeUnit(final Unit unit) {
    final Coordinate c = this.ubAssociation.getCoordinate(unit);
    if (c != null) {
      getTileAt(c).removeUnit(unit);
      this.ubAssociation.removeAssociation(unit);
    }
  }

  public void removeUnits(final int posX, final int posY) {
    final Tile tile = getTile(posX, posY);
    tile.removeUnits();
  }

  public List<Unit> getUnits(final int posX, final int posY) {
    return getTile(posX, posY).getUnits();
  }

  public Coordinate whereIs(final Unit unit) {
    return this.ubAssociation.getCoordinate(unit);
  }
}
