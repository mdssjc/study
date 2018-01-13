package com.github.mdssjc.design_patterns.factory_method;

/**
 * Concrete Creator.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteCreator implements Creator {

  @Override
  public Product factoryMethod() {
    return new ConcreteProduct("Concrete Product");
  }
}
