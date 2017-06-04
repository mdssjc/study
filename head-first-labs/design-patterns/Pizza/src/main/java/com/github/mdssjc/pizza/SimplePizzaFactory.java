package com.github.mdssjc.pizza;

import com.github.mdssjc.pizza.others.CheesePizza;
import com.github.mdssjc.pizza.others.ClamPizza;
import com.github.mdssjc.pizza.others.PepperoniPizza;
import com.github.mdssjc.pizza.others.VeggiePizza;

public class SimplePizzaFactory {

  public Pizza createPizza(final String type) {
    Pizza pizza = null;
    if (type.equals("cheese")) {
      pizza = new CheesePizza();
    } else if (type.equals("pepperoni")) {
      pizza = new PepperoniPizza();
    } else if (type.equals("clam")) {
      pizza = new ClamPizza();
    } else if (type.equals("veggie")) {
      pizza = new VeggiePizza();
    }
    return pizza;
  }
}
