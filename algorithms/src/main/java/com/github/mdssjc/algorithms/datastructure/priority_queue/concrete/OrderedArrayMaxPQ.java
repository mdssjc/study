package com.github.mdssjc.algorithms.datastructure.priority_queue.concrete;

import com.github.mdssjc.algorithms.datastructure.priority_queue.PriorityQueue;

/**
 * OrderedArrayMaxPQ Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class OrderedArrayMaxPQ<Key extends Comparable<Key>> implements PriorityQueue<Key> {

  private final Key[] pq;
  private int n;

  public OrderedArrayMaxPQ(final int capacity) {
    this.pq = (Key[]) (new Comparable[capacity]);
    this.n = 0;
  }

  @Override
  public void insert(final Key key) {
    int i = this.n - 1;
    while (i >= 0 && less(key, this.pq[i])) {
      this.pq[i + 1] = this.pq[i];
      i--;
    }
    this.pq[i + 1] = key;
    this.n++;
  }

  @Override
  public Key delete() {
    return delMax();
  }

  public Key delMax() {
    return this.pq[--this.n];
  }

  @Override
  public boolean isEmpty() {
    return this.n == 0;
  }

  @Override
  public int size() {
    return this.n;
  }
}
