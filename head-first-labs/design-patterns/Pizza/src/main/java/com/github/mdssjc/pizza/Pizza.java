package com.github.mdssjc.pizza;

import com.github.mdssjc.pizza.ingredients.*;
import lombok.Getter;
import lombok.Setter;

public abstract class Pizza {

  @Getter
  @Setter
  protected String name;
  protected Dough dough;
  protected Sauce sauce;
  protected Veggies veggies[];
  protected Cheese cheese;
  protected Pepperoni pepperoni;
  protected Clams clam;

  public abstract void prepare();

  public void bake() {
    System.out.println("Bake for 25 minutes at 350");
  }

  public void cut() {
    System.out.println("Cutting the pizza into diagonal slices");
  }

  public void box() {
    System.out.println("Place pizza in official PizzaStore box");
  }
}
