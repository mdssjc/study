package com.github.mdssjc.dp.decorator.component;

/**
 * Classe Abstrata Component.
 *
 * @author Marcelo dos Santos
 *
 */
public abstract class Component {

  private static int result = 0;

  public void inc() {
    result++;
  }

  public void dec() {
    result--;
  }

  public abstract String text();

  public int getResult() {
    return result;
  }
}
