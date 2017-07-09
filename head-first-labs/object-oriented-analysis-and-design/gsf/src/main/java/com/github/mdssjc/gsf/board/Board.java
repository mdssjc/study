package com.github.mdssjc.gsf.board;

import com.github.mdssjc.gsf.unit.Unit;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa o Board do sistema.
 *
 * @author Marcelo dos Santos
 *
 */
public class Board {

  private final int width;
  private final int height;
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
  }

  public Tile getTile(final int posX, final int posY) {
    return this.tiles.get(posX - 1)
                     .get(posY - 1);
  }

  public void addUnit(final Unit unit, final int posX, final int posY) {
    final Tile tile = getTile(posX, posY);
    tile.addUnit(unit);
  }

  public void removeUnit(final Unit unit, final int posX, final int posY) {
    final Tile tile = getTile(posX, posY);
    tile.removeUnit(unit);
  }

  public void removeUnits(final int posX, final int posY) {
    final Tile tile = getTile(posX, posY);
    tile.removeUnits();
  }

  public List<Unit> getUnits(final int posX, final int posY) {
    return getTile(posX, posY).getUnits();
  }
}
