package com.github.mdssjc.algorithms.datastructure.bag.concrete;

import java.util.Iterator;

import com.github.mdssjc.algorithms.datastructure.bag.Bag;
import com.github.mdssjc.algorithms.datastructure.linkedlist.Node;

/**
 * Implementação do Bag com Linked List (Lista Linkada).
 * <p>
 * Interface da estrutura de dado.
 *
 * @author Marcelo dos Santos
 * 
 * @param <T>
 *          Tipo de Dado
 */
public class BagLinkedList<T> implements Bag<T> {

  private Node<T> first;
  private int     size;

  @Override
  public void add(final T item) {
    final Node<T> oldfirst = this.first;

    this.first = new Node<>();
    this.first.item = item;
    this.first.next = oldfirst;

    this.size++;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public Iterator<T> iterator() {
    return null;
  }
}
