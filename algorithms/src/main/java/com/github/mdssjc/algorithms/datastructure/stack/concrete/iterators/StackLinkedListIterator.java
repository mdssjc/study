package com.github.mdssjc.algorithms.datastructure.stack.concrete.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.github.mdssjc.algorithms.datastructure.linkedlist.Node;
import com.github.mdssjc.algorithms.datastructure.stack.concrete.StackLinkedList;

/**
 * Iterador para Stack (Pilha) com Linked List (Lista Linkada).
 *
 * @author Marcelo dos Santos
 *
 * @param <T>
 *          Tipo de Dado
 */
public class StackLinkedListIterator<T> implements Iterator<T> {

  private Node<T> current;

  public StackLinkedListIterator(final StackLinkedList<T> reference) {
    this.current = reference.getFirst();
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
