package com.github.mdssjc.design_patterns.builder;

/**
 * Concrete Builder.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteBuilder extends Builder {

  public ConcreteBuilder() {
    this.message = "Parts:";
  }

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
}
