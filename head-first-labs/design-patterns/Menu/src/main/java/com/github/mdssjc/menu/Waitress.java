package com.github.mdssjc.menu;

import java.util.Iterator;

public class Waitress {

  private final MenuComponent allMenus;

  public Waitress(final MenuComponent allMenus) {
    this.allMenus = allMenus;
  }

  public void printMenu() {
    this.allMenus.print();
  }

  public void printVegetarianMenu() {
    final Iterator<MenuComponent> iterator = this.allMenus.createIterator();
    System.out.println("\nVEGETARIAN MENU\n----");
    while (iterator.hasNext()) {
      final MenuComponent menuComponent = iterator.next();
      try {
        if (menuComponent.isVegetarian()) {
          menuComponent.print();
        }
      } catch (final UnsupportedOperationException e) {
      }
    }
  }
}
