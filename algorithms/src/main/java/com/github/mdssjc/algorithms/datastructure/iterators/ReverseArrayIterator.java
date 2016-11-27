package com.github.mdssjc.algorithms.datastructure.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterador para Reverse Array.
 *
 * @author Marcelo dos Santos
 *
 * @param <T>
 *     Tipo de Dado
 */
public class ReverseArrayIterator<T> implements Iterator<T> {

  private final T[] items;
  private int i;

  public ReverseArrayIterator(final T[] items, final int length) {
    this.items = items;
    this.i = length;
  }

  @Override
  public boolean hasNext() {
    return this.i > 0;
  }

  @Override
  public T next() {
    if (!hasNext()) {
      throw new NoSuchElementException("No Such Element Exception");
    }

    return this.items[--this.i];
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException("Unsupported Operation Exception");
  }
}
