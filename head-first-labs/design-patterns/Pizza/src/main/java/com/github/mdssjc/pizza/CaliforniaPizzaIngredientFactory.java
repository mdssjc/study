package com.github.mdssjc.pizza;

import com.github.mdssjc.pizza.ingredients.*;

public class CaliforniaPizzaIngredientFactory implements PizzaIngredientFactory {

  @Override
  public Dough createDough() {
    return new ThickCrustDough();
  }

  @Override
  public Sauce createSauce() {
    return new PlumTomatoSauce();
  }

  @Override
  public Cheese createCheese() {
    return new ParmesanCheese();
  }

  @Override
  public Veggies[] createVeggies() {
    return new Veggies[]{new BlackOlives(), new Onion(), new RedPepper()};
  }

  @Override
  public Pepperoni createPepperoni() {
    return new SlicedPepperoni();
  }

  @Override
  public Clams createClam() {
    return new FrozenClams();
  }
}
