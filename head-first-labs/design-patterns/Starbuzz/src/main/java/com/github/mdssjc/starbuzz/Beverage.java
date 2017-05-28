package com.github.mdssjc.starbuzz;

public abstract class Beverage {

  protected String description = "Unknown Beverage";
  protected Size size = Size.GRANDE;

  public String getDescription() {
    return this.description;
  }

  public Size getSize() {
    return this.size;
  }

  public abstract double cost();

  public enum Size {
    TALL, GRANDE, VENTI
  }
}
