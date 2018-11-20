package com.github.mdssjc.design_patterns.creational.factory_method;

/**
 * Concrete Product.
 *
 * @author Marcelo dos Santos
 */
public class ConcreteProduct implements Product {

  private final String message;

  public ConcreteProduct(final String message) {
    this.message = message;
  }

  @Override
  public String message() {
    return this.message;
  }
}
