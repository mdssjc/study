package com.github.mdssjc.algorithms.datastructure.priority_queue.concrete;

import com.github.mdssjc.algorithms.datastructure.linkedlist.Node;
import com.github.mdssjc.algorithms.datastructure.priority_queue.PriorityQueue;

/**
 * UnorderedLinkedListMaxPQ Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class UnorderedLinkedListMaxPQ<Key extends Comparable<Key>> implements PriorityQueue<Key> {

  private Node<Key> first;
  private int size;

  @Override
  public void insert(final Key key) {
    final Node<Key> oldfirst = this.first;

    this.first = new Node<>();
    this.first.item = key;
    this.first.next = oldfirst;

    this.size++;
  }

  @Override
  public Key delete() {
    return delMax();
  }

  public Key delMax() {
    Node<Key> max = this.first;
    Node<Key> prevMax = null;
    Node<Key> prev = this.first;
    Node<Key> current = this.first.next;

    while (current != null) {
      if (less(max.item, current.item)) {
        max = current;
        prevMax = prev;
      }
      prev = current;
      current = current.next;
    }

    if (prevMax != null) {
      prevMax.next = max.next;
    } else {
      this.first = max.next;
    }

    this.size--;
    return max.item;
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
