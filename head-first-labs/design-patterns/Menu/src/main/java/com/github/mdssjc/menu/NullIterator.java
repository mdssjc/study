package com.github.mdssjc.menu;

import java.util.Iterator;

public class NullIterator implements Iterator {

  @Override
  public boolean hasNext() {
    return false;
  }

  @Override
  public Object next() {
    return null;
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }
}
