package com.github.mdssjc.pizza;

import com.github.mdssjc.pizza.chicago.ChicagoStyleCheesePizza;
import com.github.mdssjc.pizza.chicago.ChicagoStyleClamPizza;
import com.github.mdssjc.pizza.chicago.ChicagoStylePepperoniPizza;
import com.github.mdssjc.pizza.chicago.ChicagoStyleVeggiePizza;

public class ChicagoPizzaStore extends PizzaStore {

  @Override
  public Pizza createPizza(final String item) {
    Pizza pizza = null;

    if (item.equals("cheese")) {
      pizza = new ChicagoStyleCheesePizza();
    } else if (item.equals("pepperoni")) {
      pizza = new ChicagoStylePepperoniPizza();
    } else if (item.equals("clam")) {
      pizza = new ChicagoStyleClamPizza();
    } else if (item.equals("veggie")) {
      pizza = new ChicagoStyleVeggiePizza();
    }

    return pizza;
  }
}
