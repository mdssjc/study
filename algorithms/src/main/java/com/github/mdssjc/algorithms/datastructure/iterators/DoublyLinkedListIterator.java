package com.github.mdssjc.algorithms.datastructure.iterators;

import com.github.mdssjc.algorithms.datastructure.linkedlist.DoubleNode;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterador para Doubly Linked List (Lista Duplamente Linkada).
 *
 * @author Marcelo dos Santos
 *
 * @param <T>
 *     Tipo de Dado
 */
public class DoublyLinkedListIterator<T> implements Iterator<T> {

  private DoubleNode<T> current;

  public DoublyLinkedListIterator(final DoubleNode<T> reference) {
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

    final T item = this.current.item;
    this.current = this.current.next;
    return item;
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException("Unsupported Operation Exception");
  }
}
