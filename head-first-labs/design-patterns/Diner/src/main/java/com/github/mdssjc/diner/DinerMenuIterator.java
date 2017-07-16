package com.github.mdssjc.diner;

public class DinerMenuIterator<T> implements Iterator<MenuItem> {

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
}
