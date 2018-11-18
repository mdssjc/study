package com.github.mdssjc.design_patterns.behavioral.strategy;

/**
 * Context.
 *
 * @author Marcelo dos Santos
 */
public class Context {

  private Strategy strategy;

  public void setStrategy(final Strategy strategy) {
    this.strategy = strategy;
  }

  public String contextInterface() {
    return this.strategy.algorithmInterface();
  }
}
