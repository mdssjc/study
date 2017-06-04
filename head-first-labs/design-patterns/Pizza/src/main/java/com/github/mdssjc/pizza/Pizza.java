package com.github.mdssjc.pizza;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {

  @Getter
  protected String name;
  protected String dough;
  protected String sauce;
  protected final List<String> toppings;

  public Pizza() {
    this.toppings = new ArrayList();
  }

  public void prepare() {
    System.out.println("Preparing " + this.name);
    System.out.println("Tossing dough...");
    System.out.println("Adding sauce...");
    System.out.println("Adding toppings: ");

    this.toppings.forEach(t -> System.out.println(" " + t));
  }

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
