package com.github.mdssjc.diner;

import java.util.Iterator;

public class DinerMenuIterator implements Iterator<MenuItem> {

  private final MenuItem[] items;
  private int position = 0;

  public DinerMenuIterator(final MenuItem[] items) {
    this.items = items;
  }

  @Override
  public boolean hasNext() {
    return !(this.position >= this.items.length ||
             this.items[this.position] == null);
  }

  @Override
  public MenuItem next() {
    final MenuItem menuItem = this.items[this.position];
    this.position++;
    return menuItem;
  }

  public void remove() {
    if (this.position <= 0) {
      throw new IllegalStateException(
          "You can’t remove an item until you’ve done at least one next()");
    }

    if (this.items[this.position - 1] != null) {
      for (int i = this.position - 1; i < (this.items.length - 1); i++) {
        this.items[i] = this.items[i + 1];
      }
      this.items[this.items.length - 1] = null;
    }
  }
}
