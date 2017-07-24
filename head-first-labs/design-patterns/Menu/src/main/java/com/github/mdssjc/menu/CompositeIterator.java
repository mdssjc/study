package com.github.mdssjc.menu;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator<MenuComponent> {

  private final Stack<Iterator<MenuComponent>> stack;

  public CompositeIterator(final Iterator<MenuComponent> iterator) {
    this.stack = new Stack();
    this.stack.push(iterator);
  }

  @Override
  public boolean hasNext() {
    if (this.stack.empty()) {
      return false;
    } else {
      final Iterator<MenuComponent> iterator = this.stack.peek();
      if (!iterator.hasNext()) {
        this.stack.pop();
        return hasNext();
      } else {
        return true;
      }
    }
  }

  @Override
  public MenuComponent next() {
    if (hasNext()) {
      final Iterator<MenuComponent> iterator = this.stack.peek();
      final MenuComponent component = iterator.next();
      if (component instanceof Menu) {
        this.stack.push(component.createIterator());
      }
      return component;
    } else {
      return null;
    }
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }
}
