package com.github.mdssjc.diner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PancakeHouseMenu implements Menu {

  private final List<MenuItem> menuItems;

  public PancakeHouseMenu() {
    this.menuItems = new ArrayList<>();
    initialize();
  }

  private void initialize() {
    addItem("K&B’s Pancake Breakfast",
            "Pancakes with scrambled eggs, and toast",
            true,
            2.99);
    addItem("Regular Pancake Breakfast",
            "Pancakes with fried eggs, sausage",
            false,
            2.99);
    addItem("Blueberry Pancakes",
            "Pancakes made with fresh blueberries",
            true,
            3.49);
    addItem("Waffles",
            "Waffles, with your choice of blueberries or strawberries",
            true,
            3.59);
  }

  public void addItem(final String name, final String description,
                      final boolean vegetarian, final double price) {
    this.menuItems.add(new MenuItem(name, description,
                                    vegetarian, price));
  }

  @Override
  public Iterator<MenuItem> createIterator() {
    return menuItems.iterator();
  }
}
