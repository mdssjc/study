package com.github.mdssjc.design_patterns.creational.singleton;

/**
 * Simple Eager Singleton.
 *
 * @author Marcelo dos Santos
 *
 */
public class SimpleEagerSingleton {

  private static final SimpleEagerSingleton instance = new SimpleEagerSingleton();
  private int value;

  private SimpleEagerSingleton() {
  }

  public static SimpleEagerSingleton instance() {
    return SimpleEagerSingleton.instance;
  }

  public String getData() {
    return "Count: " + this.value;
  }

  public void operation() {
    this.value++;
  }
}
