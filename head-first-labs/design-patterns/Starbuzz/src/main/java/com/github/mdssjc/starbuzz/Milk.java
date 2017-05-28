package com.github.mdssjc.starbuzz;

public class Milk extends CondimentDecorator {

  private final Beverage beverage;

  public Milk(final Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public String getDescription() {
    return this.beverage.getDescription() + ", Milk";
  }

  @Override
  public double cost() {
    return this.beverage.cost() + 0.10;
  }
}
