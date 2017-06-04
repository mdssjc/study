package com.github.mdssjc.pizza.pizzas;

import com.github.mdssjc.pizza.Pizza;
import com.github.mdssjc.pizza.PizzaIngredientFactory;

public class VeggiePizza extends Pizza {

  private final PizzaIngredientFactory ingredientFactory;

  public VeggiePizza(final PizzaIngredientFactory ingredientFactory) {
    this.ingredientFactory = ingredientFactory;
  }

  @Override
  public void prepare() {
    System.out.println("Preparing " + this.name);
    this.dough = this.ingredientFactory.createDough();
    this.sauce = this.ingredientFactory.createSauce();
    this.veggies = this.ingredientFactory.createVeggies();
  }
}
