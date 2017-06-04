package com.github.mdssjc.pizza;

import com.github.mdssjc.pizza.ny.NYStyleCheesePizza;
import com.github.mdssjc.pizza.ny.NYStyleClamPizza;
import com.github.mdssjc.pizza.ny.NYStylePepperoniPizza;
import com.github.mdssjc.pizza.ny.NYStyleVeggiePizza;

public class NYPizzaStore extends PizzaStore {

  @Override
  public Pizza createPizza(final String type) {
    Pizza pizza = null;

    if (type.equals("cheese")) {
      pizza = new NYStyleCheesePizza();
    } else if (type.equals("pepperoni")) {
      pizza = new NYStylePepperoniPizza();
    } else if (type.equals("clam")) {
      pizza = new NYStyleClamPizza();
    } else if (type.equals("veggie")) {
      pizza = new NYStyleVeggiePizza();
    }

    return pizza;
  }
}
