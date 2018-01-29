package com.github.mdssjc.design_patterns.creational.singleton;

/**
 * Enum Singleton.
 *
 * @author Marcelo dos Santos
 *
 */
public enum EnumSingleton {
  INSTANCE;

  private int value;

  public String getData() {
    return "Count: " + this.value;
  }

  public void operation() {
    this.value++;
  }
}
