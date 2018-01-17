package com.github.mdssjc.design_patterns.creational.abstract_factory;

/**
 * Concrete Product.
 *
 * @author Marcelo dos Santos
 *
 */
public class ProductA1 implements AbstractProductA {

  @Override
  public void message() {
    System.out.println("Concrete Product A1");
  }
}
