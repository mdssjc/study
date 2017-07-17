package com.github.mdssjc.menu;

import java.util.Calendar;
import java.util.Iterator;

public class AlternatingDinerMenuIterator implements Iterator<MenuItem> {

  private final MenuItem[] items;
  private int position;

  public AlternatingDinerMenuIterator(final MenuItem[] items) {
    this.items = items;
    final Calendar rightNow = Calendar.getInstance();
    this.position = rightNow.get(Calendar.DAY_OF_WEEK) % 2;
  }

  @Override
  public boolean hasNext() {
    return !(this.position >= this.items.length ||
             this.items[this.position] == null);
  }

  @Override
  public MenuItem next() {
    final MenuItem menuItem = this.items[this.position];
    this.position = this.position + 2;
    return menuItem;
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException(
        "Alternating Diner Menu Iterator does not support remove()");
  }
}
