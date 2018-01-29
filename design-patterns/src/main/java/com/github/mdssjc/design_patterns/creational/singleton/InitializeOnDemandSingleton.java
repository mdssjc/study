package com.github.mdssjc.design_patterns.creational.singleton;

/**
 * Initialize On Demand Singleton.
 *
 * @author Marcelo dos Santos
 *
 */
public class InitializeOnDemandSingleton {

  private int value;

  private InitializeOnDemandSingleton() {
  }

  public static InitializeOnDemandSingleton instance() {
    return ResourceHolder.instance;
  }

  public String getData() {
    return "Count: " + this.value;
  }

  public void operation() {
    this.value++;
  }

  private static class ResourceHolder {

    private static final InitializeOnDemandSingleton instance = new InitializeOnDemandSingleton();
  }
}
