package com.github.mdssjc.starbuzz;

public class Milk extends CondimentDecorator {

  private Beverage beverage;

  public Milk(final Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", Milk";
  }

  @Override
  public double cost() {
    return beverage.cost() + 0.10;
  }
}
