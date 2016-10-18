package com.github.mdssjc.algorithms.datastructure.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterador para Array.
 *
 * @author Marcelo dos Santos
 *
 * @param <T>
 *     Tipo de Dado
 */
public class ArrayIterator<T> implements Iterator<T> {

  private final T[] items;
  private final int length;
  private int index;

  public ArrayIterator(final T[] items, final int length) {
    this.items = items;
    this.length = length;
  }

  @Override
  public boolean hasNext() {
    return this.index < this.length;
  }

  @Override
  public T next() {
    if (!hasNext()) {
      throw new NoSuchElementException("No Such Element Exception");
    }

    return this.items[this.index++];
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException(
        "Unsupported Operation Exception");
  }
}
