package com.github.mdssjc.algorithms.stack.concrete.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

import lombok.AllArgsConstructor;

/**
 * Iterador para Stack (Pilha) com Array.
 *
 * @author Marcelo dos Santos
 *
 * @param <Item> Tipo de Dado
 */
@AllArgsConstructor
public class StackArrayIterator<Item> implements Iterator<Item> {

  private final Item[] items;
  private int          i;

  @Override
  public boolean hasNext() {
    return this.i > 0;
  }

  @Override
  public Item next() {
    if (!hasNext()) {
      throw new NoSuchElementException("No Such Element Exception");
    }

    return this.items[--this.i];
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException(
        "Unsupported Operation Exception");
  }
}
