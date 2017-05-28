package com.github.mdssjc.starbuzz;

public class Mocha extends CondimentDecorator {

  private final Beverage beverage;

  public Mocha(final Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public String getDescription() {
    return this.beverage.getDescription() + ", Mocha";
  }

  @Override
  public double cost() {
    return this.beverage.cost() + 0.20;
  }
}
