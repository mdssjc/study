package com.github.mdssjc.pizza;

import com.github.mdssjc.pizza.pizzas.CheesePizza;
import com.github.mdssjc.pizza.pizzas.ClamPizza;
import com.github.mdssjc.pizza.pizzas.PepperoniPizza;
import com.github.mdssjc.pizza.pizzas.VeggiePizza;

public class CaliforniaPizzaStore extends PizzaStore {

  @Override
  public Pizza createPizza(final String item) {
    Pizza pizza = null;
    final PizzaIngredientFactory ingredientFactory = new CaliforniaPizzaIngredientFactory();

    if (item.equals("cheese")) {
      pizza = new CheesePizza(ingredientFactory);
      pizza.setName("California Style Cheese Pizza");
    } else if (item.equals("veggie")) {
      pizza = new VeggiePizza(ingredientFactory);
      pizza.setName("California Style Veggie Pizza");
    } else if (item.equals("clam")) {
      pizza = new ClamPizza(ingredientFactory);
      pizza.setName("California Style Clam Pizza");
    } else if (item.equals("pepperoni")) {
      pizza = new PepperoniPizza(ingredientFactory);
      pizza.setName("California Style Pepperoni Pizza");
    }

    return pizza;
  }
}
