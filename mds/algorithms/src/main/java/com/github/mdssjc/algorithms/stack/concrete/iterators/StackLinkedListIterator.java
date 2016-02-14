package com.github.mdssjc.algorithms.stack.concrete.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.github.mdssjc.algorithms.linkedlist.Node;
import com.github.mdssjc.algorithms.stack.concrete.StackLinkedList;

/**
 * Iterador para Stack (Pilha) com Linked List (Lista Linkada).
 *
 * @author Marcelo dos Santos
 *
 * @param <Item>
 *          Tipo de Dado
 */
public class StackLinkedListIterator<Item> implements Iterator<Item> {

  private Node<Item> current;

  public StackLinkedListIterator(final StackLinkedList<Item> reference) {
    this.current = reference.getFirst();
  }

  @Override
  public boolean hasNext() {
    return this.current != null;
  }

  @Override
  public Item next() {
    if (!hasNext()) {
      throw new NoSuchElementException("No Such Element Exception");
    }

    final Item item = this.current.getItem();
    this.current = this.current.getNext();
    return item;
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException(
        "Unsupported Operation Exception");
  }
}
