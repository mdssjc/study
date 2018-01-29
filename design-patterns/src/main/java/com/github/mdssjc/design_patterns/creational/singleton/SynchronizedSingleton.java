package com.github.mdssjc.design_patterns.creational.singleton;

/**
 * Synchronized Singleton.
 *
 * @author Marcelo dos Santos
 *
 */
public class SynchronizedSingleton {

  private static SynchronizedSingleton instance;
  private int value;

  private SynchronizedSingleton() {
  }

  public static synchronized SynchronizedSingleton instance() {
    if (instance == null) {
      instance = new SynchronizedSingleton();
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
