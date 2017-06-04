package com.github.mdssjc.pizza;

public abstract class PizzaStore {

  public Pizza orderPizza(final String type) {
    final Pizza pizza = createPizza(type);

    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();

    return pizza;
  }

  public abstract Pizza createPizza(String type);
}
