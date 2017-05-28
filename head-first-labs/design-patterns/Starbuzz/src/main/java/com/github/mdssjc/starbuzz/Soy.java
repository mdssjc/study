package com.github.mdssjc.starbuzz;

public class Soy extends CondimentDecorator {

  private final Beverage beverage;

  public Soy(final Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public String getDescription() {
    return this.beverage.getDescription() + ", Soy";
  }

  @Override
  public double cost() {
    double cost = this.beverage.cost();
    switch (getSize()) {
      case TALL:
        cost += .10;
        break;
      case GRANDE:
        cost += .15;
        break;
      case VENTI:
        cost += .20;
        break;
    }
    return cost;
  }
}
