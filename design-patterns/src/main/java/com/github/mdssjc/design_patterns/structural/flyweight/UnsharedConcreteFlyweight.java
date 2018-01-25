package com.github.mdssjc.design_patterns.structural.flyweight;

/**
 * Unshared Concrete Flyweight.
 *
 * @author Marcelo dos Santos
 *
 */
public class UnsharedConcreteFlyweight implements Flyweight {

  @Override
  public String operation(final String extrinsicState) {
    return extrinsicState + "Unshared Concrete Flyweight";
  }
}
