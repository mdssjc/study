package com.github.mdssjc.diner;

public interface Waitress {

  /**
   * Prints every item on the menu.
   */
  void printMenu();

  /**
   * Prints just breakfast items.
   */
  void printBreakfastMenu();

  /**
   * Prints just lunch items.
   */
  void printLunchMenu();

  /**
   * Prints all vegetarian menu items.
   */
  void printVegetarianMenu();

  /**
   * Given the name of an item, returns true
   * if the items is vegetarian, otherwise,
   * returns false.
   *
   * @param name
   *     Name of an item
   *
   * @return true if is vegetarian, otherwise false
   */
  boolean isItemVegetarian(String name);
}
