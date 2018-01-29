package com.github.mdssjc.design_patterns.creational.singleton;

/**
 * Double Check Singleton.
 *
 * @author Marcelo dos Santos
 *
 */
public class DoubleCheckSingleton {

  private static volatile DoubleCheckSingleton instance;
  private int value;

  private DoubleCheckSingleton() {
  }

  public static DoubleCheckSingleton instance() {
    if (instance == null) {
      synchronized (DoubleCheckSingleton.class) {
        if (instance == null) {
          instance = new DoubleCheckSingleton();
        }
      }
    }
    return DoubleCheckSingleton.instance;
  }

  public String getData() {
    return "Count: " + this.value;
  }

  public void operation() {
    this.value++;
  }
}
