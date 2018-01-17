package com.github.mdssjc.design_patterns.singleton;

/**
 * Singleton.
 *
 * @author Marcelo dos Santos
 *
 */
public class Singleton {

  private static Singleton instance;
  private int value;

  private Singleton() {
  }

  public static Singleton instance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }

  public String getData() {
    return "Count: " + this.value;
  }

  public void operation() {
    this.value++;
  }
}
