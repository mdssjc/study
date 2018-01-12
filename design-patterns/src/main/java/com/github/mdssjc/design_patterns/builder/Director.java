package com.github.mdssjc.design_patterns.builder;

/**
 * Director.
 *
 * @author Marcelo dos Santos
 *
 */
public class Director {

  private final Builder builder;

  public Director(final Builder builder) {
    this.builder = builder;
  }

  public void construct() {
    this.builder.buildPartA();
    this.builder.buildPartB();
    this.builder.buildPartC();
  }
}
