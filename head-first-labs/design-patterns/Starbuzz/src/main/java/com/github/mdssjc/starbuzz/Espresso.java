package com.github.mdssjc.starbuzz;

public class Espresso extends Beverage {

  public Espresso() {
    this.description = "Espresso";
  }

  @Override
  public double cost() {
    return 1.99;
  }
}
