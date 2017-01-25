package com.github.mdssjc.dp.monostate;

/**
 * Implementação do Monostate.
 *
 * @author Marcelo dos Santos
 *
 */
public class Monostate {

  private static int x;

  public int getX() {
    return Monostate.x;
  }

  public void setX(final int x) {
    Monostate.x = x;
  }
}
