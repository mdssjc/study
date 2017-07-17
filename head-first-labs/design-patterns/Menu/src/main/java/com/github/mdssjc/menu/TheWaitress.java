package com.github.mdssjc.menu;

import java.util.Iterator;

public class TheWaitress implements Waitress {

  private final Menu pancakeHouseMenu;
  private final Menu dinerMenu;
  private final Menu cafeMenu;

  public TheWaitress(final Menu pancakeHouseMenu,
                     final Menu dinerMenu, final Menu cafeMenu) {
    this.pancakeHouseMenu = pancakeHouseMenu;
    this.dinerMenu = dinerMenu;
    this.cafeMenu = cafeMenu;
  }

  @Override
  public void printMenu() {
    final Iterator pancakeIterator = this.pancakeHouseMenu.createIterator();
    final Iterator dinerIterator = this.dinerMenu.createIterator();
    final Iterator cafeIterator = this.cafeMenu.createIterator();

    System.out.println("MENU\n----\nBREAKFAST");
    printMenu(pancakeIterator);
    System.out.println("\nLUNCH");
    printMenu(dinerIterator);
    System.out.println("\nDINNER");
    printMenu(cafeIterator);
  }

  private void printMenu(final Iterator<MenuItem> iterator) {
    while (iterator.hasNext()) {
      final MenuItem menuItem = iterator.next();
      System.out.print(menuItem.getName() + ", ");
      System.out.print(menuItem.getPrice() + " -- ");
      System.out.println(menuItem.getDescription());
    }
  }

  @Override
  public void printBreakfastMenu() {
  }

  @Override
  public void printLunchMenu() {
  }

  @Override
  public void printVegetarianMenu() {
  }

  @Override
  public boolean isItemVegetarian(final String name) {
    return false;
  }
}
