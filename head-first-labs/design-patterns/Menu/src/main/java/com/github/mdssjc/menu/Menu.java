package com.github.mdssjc.menu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu extends MenuComponent {

  private final List<MenuComponent> menuComponents;
  private final String name;
  private final String description;
  private Iterator iterator;

  public Menu(final String name, final String description) {
    this.name = name;
    this.description = description;
    this.menuComponents = new ArrayList<>();
  }

  public void add(final MenuComponent menuComponent) {
    this.menuComponents.add(menuComponent);
  }

  public void remove(final MenuComponent menuComponent) {
    this.menuComponents.remove(menuComponent);
  }

  public MenuComponent getChild(final int i) {
    return this.menuComponents.get(i);
  }

  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return this.description;
  }

  public void print() {
    System.out.print("\n" + getName());
    System.out.println(", " + getDescription());
    System.out.println("---------------------");

    final Iterator<MenuComponent> iterator = this.menuComponents.iterator();
    while (iterator.hasNext()) {
      final MenuComponent menuComponent = iterator.next();
      menuComponent.print();
    }
  }

  @Override
  public Iterator createIterator() {
    if (this.iterator == null) {
      this.iterator = new CompositeIterator(this.menuComponents.iterator());
    }
    return this.iterator;
  }
}
