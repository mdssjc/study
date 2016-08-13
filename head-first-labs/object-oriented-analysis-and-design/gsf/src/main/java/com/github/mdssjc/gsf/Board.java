package com.github.mdssjc.gsf;

/**
 * Representa o Board do sistema.
 * 
 * @author Marcelo dos Santos
 *
 */
public class Board {

  private final int width;
  private final int height;

  public Board(final int width, final int height) {
    this.width = width;
    this.height = height;
  }

  public Tile getTile(final int posX, final int posY) {
    return null;
  }

  public void addTile(final int posX, final int posY, final Tile tile) {
  }

  public Unit[] getUnits(final int posX, final int posY) {
    return null;
  }
}
