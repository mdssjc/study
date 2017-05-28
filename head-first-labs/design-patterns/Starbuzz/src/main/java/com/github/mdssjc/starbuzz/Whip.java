package com.github.mdssjc.starbuzz;

public class Whip extends CondimentDecorator {

  private Beverage beverage;

  public Whip(final Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", Whip";
  }

  @Override
  public double cost() {
    return beverage.cost() + 0.10;
  }
}
