package com.github.mdssjc.algorithms.datastructure.bag.concrete;

import com.github.mdssjc.algorithms.datastructure.bag.Bag;
import com.github.mdssjc.algorithms.datastructure.iterators.LinkedListIterator;
import com.github.mdssjc.algorithms.datastructure.linkedlist.Node;

import java.util.Iterator;

/**
 * Implementação do Bag com Linked List.
 *
 * @author Marcelo dos Santos
 *
 * @param <Item>
 *     Tipo de Dado
 */
public class BagLinkedList<Item> implements Bag<Item> {

  private Node<Item> first;
  private int size;

  @Override
  public void add(final Item item) {
    final Node<Item> oldfirst = this.first;

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
  public Iterator<Item> iterator() {
    return new LinkedListIterator<>(this.first);
  }
}
