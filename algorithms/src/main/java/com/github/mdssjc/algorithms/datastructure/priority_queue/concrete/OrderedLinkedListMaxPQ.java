package com.github.mdssjc.algorithms.datastructure.priority_queue.concrete;

import com.github.mdssjc.algorithms.datastructure.linkedlist.Node;
import com.github.mdssjc.algorithms.datastructure.priority_queue.PriorityQueue;

/**
 * OrderedLinkedListMaxPQ Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class OrderedLinkedListMaxPQ<Key extends Comparable<Key>> implements PriorityQueue<Key> {

  private Node<Key> first;
  private int size;

  @Override
  public void insert(final Key key) {
    Node<Key> prev = null;
    Node<Key> current = this.first;

    while (current != null && less(key, current.item)) {
      prev = current;
      current = current.next;
    }

    final Node<Key> node = new Node<>();
    node.item = key;
    node.next = current;

    if (prev == null) {
      this.first = node;
    } else {
      prev.next = node;
    }

    this.size++;
  }

  @Override
  public Key delete() {
    return delMax();
  }

  public Key delMax() {
    final Key max = this.first.item;
    this.first = this.first.next;
    this.size--;
    return max;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public int size() {
    return this.size;
  }
}
