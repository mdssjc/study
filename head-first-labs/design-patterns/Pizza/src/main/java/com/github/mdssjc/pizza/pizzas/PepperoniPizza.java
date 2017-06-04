package com.github.mdssjc.pizza.pizzas;

import com.github.mdssjc.pizza.Pizza;
import com.github.mdssjc.pizza.PizzaIngredientFactory;

public class PepperoniPizza extends Pizza {

  private final PizzaIngredientFactory ingredientFactory;

  public PepperoniPizza(final PizzaIngredientFactory ingredientFactory) {
    this.ingredientFactory = ingredientFactory;
  }

  @Override
  public void prepare() {
    System.out.println("Preparing " + this.name);
    this.dough = this.ingredientFactory.createDough();
    this.sauce = this.ingredientFactory.createSauce();
    this.pepperoni = this.ingredientFactory.createPepperoni();
  }
}
