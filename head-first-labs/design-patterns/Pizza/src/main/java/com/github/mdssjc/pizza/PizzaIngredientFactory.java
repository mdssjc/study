package com.github.mdssjc.pizza;

import com.github.mdssjc.pizza.ingredients.*;

public interface PizzaIngredientFactory {

  Dough createDough();

  Sauce createSauce();

  Cheese createCheese();

  Veggies[] createVeggies();

  Pepperoni createPepperoni();

  Clams createClam();
}
