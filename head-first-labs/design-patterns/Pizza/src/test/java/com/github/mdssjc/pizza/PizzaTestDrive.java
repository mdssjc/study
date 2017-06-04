package com.github.mdssjc.pizza;

public class PizzaTestDrive {

  public static void main(final String[] args) {
    final PizzaStore nyStore = new NYPizzaStore();
    final PizzaStore chicagoStore = new ChicagoPizzaStore();

    Pizza pizza = nyStore.orderPizza("cheese");
    System.out.printf("Ethan ordered a %s%n%n", pizza.getName());

    pizza = chicagoStore.orderPizza("cheese");
    System.out.printf("Joel ordered a %s%n%n", pizza.getName());
  }
}
