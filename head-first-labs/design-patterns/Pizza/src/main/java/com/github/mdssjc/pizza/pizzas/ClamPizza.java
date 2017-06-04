package com.github.mdssjc.pizza.pizzas;

import com.github.mdssjc.pizza.Pizza;
import com.github.mdssjc.pizza.PizzaIngredientFactory;

public class ClamPizza extends Pizza {

  private final PizzaIngredientFactory ingredientFactory;

  public ClamPizza(final PizzaIngredientFactory ingredientFactory) {
    this.ingredientFactory = ingredientFactory;
  }

  @Override
  public void prepare() {
    System.out.println("Preparing " + this.name);
    this.dough = this.ingredientFactory.createDough();
    this.sauce = this.ingredientFactory.createSauce();
    this.cheese = this.ingredientFactory.createCheese();
    this.clam = this.ingredientFactory.createClam();
  }
}
