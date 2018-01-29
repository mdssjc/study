package com.github.mdssjc.design_patterns.creational.singleton;

/**
 * Simple Lazy Singleton.
 *
 * @author Marcelo dos Santos
 *
 */
public class SimpleLazySingleton {

  private static SimpleLazySingleton instance;
  private int value;

  private SimpleLazySingleton() {
  }

  public static SimpleLazySingleton instance() {
    if (instance == null) {
      instance = new SimpleLazySingleton();
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
