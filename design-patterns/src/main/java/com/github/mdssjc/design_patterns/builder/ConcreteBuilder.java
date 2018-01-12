package com.github.mdssjc.design_patterns.builder;

/**
 * Concrete Builder.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteBuilder implements Builder {

  private String message = "";

  @Override
  public void buildPartA() {
    this.message += " A";
  }

  @Override
  public void buildPartB() {
    this.message += " B";
  }

  @Override
  public void buildPartC() {
    this.message += " C";
  }

  @Override
  public Product getResult() {
    return new Product("Parts: " + this.message);
  }
}
