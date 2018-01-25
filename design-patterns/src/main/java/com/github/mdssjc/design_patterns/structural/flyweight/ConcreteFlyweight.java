package com.github.mdssjc.design_patterns.structural.flyweight;

/**
 * Concrete Flyweight.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteFlyweight implements Flyweight {

  private final String state;

  public ConcreteFlyweight(final String state) {
    this.state = state;
  }

  @Override
  public String operation(final String extrinsicState) {
    return extrinsicState + (extrinsicState.isEmpty() ? "" : this.state) + "Concrete Flyweight";
  }
}
