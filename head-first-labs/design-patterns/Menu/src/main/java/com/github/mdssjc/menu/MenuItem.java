package com.github.mdssjc.menu;

import java.util.Iterator;

public class MenuItem extends MenuComponent {

  private final String name;
  private final String description;
  private final boolean vegetarian;
  private final double price;

  public MenuItem(final String name, final String description,
                  final boolean vegetarian, final double price) {
    this.name = name;
    this.description = description;
    this.vegetarian = vegetarian;
    this.price = price;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getDescription() {
    return this.description;
  }

  @Override
  public double getPrice() {
    return this.price;
  }

  @Override
  public boolean isVegetarian() {
    return this.vegetarian;
  }

  @Override
  public void print() {
    System.out.print(" " + getName());
    if (isVegetarian()) {
      System.out.print("(v)");
    }
    System.out.println(", " + getPrice());
    System.out.println(" -- " + getDescription());
  }

  @Override
  public Iterator createIterator() {
    return new NullIterator();
  }
}
