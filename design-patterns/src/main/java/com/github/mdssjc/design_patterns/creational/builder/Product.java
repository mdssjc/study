package com.github.mdssjc.design_patterns.creational.builder;

/**
 * Product.
 *
 * @author Marcelo dos Santos
 *
 */
public class Product {

  private final String message;

  public Product(final String message) {
    this.message = message;
  }

  public void message() {
    System.out.println(this.message);
  }
}
