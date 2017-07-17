package com.github.mdssjc.menu;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class CafeMenu implements Menu {

  private final Map<String, MenuItem> menuItems;

  public CafeMenu() {
    this.menuItems = new Hashtable<>();
    initialize();
  }

  private void initialize() {
    addItem("Veggie Burger and Air Fries",
            "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
            true, 3.99);
    addItem("Soup of the day",
            "A cup of the soup of the day, with a side salad",
            false, 3.69);
    addItem("Burrito",
            "A large burrito, with whole pinto beans, salsa, guacamole",
            true, 4.29);
  }

  public void addItem(final String name, final String description,
                      final boolean vegetarian, final double price) {
    final MenuItem menuItem = new MenuItem(name, description,
                                           vegetarian, price);
    this.menuItems.put(menuItem.getName(), menuItem);
  }

  @Override
  public Iterator<MenuItem> createIterator() {
    return this.menuItems.values()
                         .iterator();
  }
}
