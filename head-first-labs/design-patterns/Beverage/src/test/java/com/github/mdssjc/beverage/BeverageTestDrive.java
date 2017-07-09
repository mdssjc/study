package com.github.mdssjc.beverage;

public class BeverageTestDrive {

  public static void main(final String[] args) {
    final CaffeineBeverage tea = new Tea();
    final CaffeineBeverage coffee = new Coffee();

    System.out.println("\nMaking tea...");
    tea.prepareRecipe();

    System.out.println("\nMaking coffee...");
    coffee.prepareRecipe();
  }
}
