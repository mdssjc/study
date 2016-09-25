package com.github.mdssjc.algorithms.datastructure.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.github.mdssjc.algorithms.datastructure.linkedlist.Node;

/**
 * Iterador para Linked List (Lista Linkada).
 *
 * @author Marcelo dos Santos
 *
 * @param <T>
 *          Tipo de Dado
 */
public class LinkedListIterator<T> implements Iterator<T> {

  private Node<T> current;

  public LinkedListIterator(final Node<T> reference) {
    this.current = reference;
  }

  @Override
  public boolean hasNext() {
    return this.current != null;
  }

  @Override
  public T next() {
    if (!hasNext()) {
      throw new NoSuchElementException("No Such Element Exception");
    }

    final T item = this.current.getItem();
    this.current = this.current.getNext();
    return item;
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException(
        "Unsupported Operation Exception");
  }
}
