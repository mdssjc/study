package com.github.mdssjc.pizza;

public class PizzaTestDrive {

  public static void main(final String[] args) {
    final PizzaStore nyPizzaStore = new NYPizzaStore();
    final PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
    final PizzaStore californiaPizzaStore = new CaliforniaPizzaStore();

    Pizza pizza = nyPizzaStore.orderPizza("cheese");
    System.out.printf("Ethan ordered a %s%n%n", pizza.getName());

    pizza = chicagoPizzaStore.orderPizza("cheese");
    System.out.printf("Joel ordered a %s%n%n", pizza.getName());

    pizza = californiaPizzaStore.orderPizza("cheese");
    System.out.printf("MDS ordered a %s%n%n", pizza.getName());
  }
}
