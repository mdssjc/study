package com.github.mdssjc.starbuzz;

public abstract class Beverage {

  private String description;

  public String getDescription() {
    return this.description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public abstract double cost();
}
