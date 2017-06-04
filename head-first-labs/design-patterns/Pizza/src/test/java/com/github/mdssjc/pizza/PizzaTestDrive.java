package com.github.mdssjc.pizza;

public class PizzaTestDrive {

  public static void main(final String[] args) {
    final PizzaStore nyPizzaStore = new NYPizzaStore();
    final PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();

    Pizza pizza = nyPizzaStore.orderPizza("cheese");
    System.out.printf("Ethan ordered a %s%n%n", pizza.getName());

    pizza = chicagoPizzaStore.orderPizza("cheese");
    System.out.printf("Joel ordered a %s%n%n", pizza.getName());
  }
}
