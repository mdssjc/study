package com.github.mdssjc.design_patterns.creational.builder;

/**
 * Builder.
 *
 * @author Marcelo dos Santos
 *
 */
public abstract class Builder {

  protected String message = "";

  public abstract void buildPartA();

  public abstract void buildPartB();

  public abstract void buildPartC();

  public Product getResult() {
    return new Product(this.message);
  }
}
