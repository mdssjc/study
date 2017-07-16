package com.github.mdssjc.diner;

import java.util.List;

public class PancakeHouseIterator implements Iterator<MenuItem> {

  private final List<MenuItem> items;
  private int position = 0;

  public PancakeHouseIterator(final List<MenuItem> items) {
    this.items = items;
  }

  @Override
  public boolean hasNext() {
    return !(this.position >= this.items.size() ||
             this.items.get(this.position) == null);
  }

  @Override
  public MenuItem next() {
    return this.items.get(this.position++);
  }
}
