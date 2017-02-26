package com.github.mdssjc.algorithms.datastructure.priority_queue.concrete;

import com.github.mdssjc.algorithms.datastructure.priority_queue.OrderedArrayPQ;

/**
 * UnorderedArrayMaxPQ Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class UnorderedArrayMaxPQ<Key extends Comparable<Key>> implements OrderedArrayPQ<Key> {

  private final Key[] pq;
  private int n;

  public UnorderedArrayMaxPQ(final int capacity) {
    this.pq = (Key[]) new Comparable[capacity];
    this.n = 0;
  }

  @Override
  public void insert(final Key x) {
    this.pq[this.n++] = x;
  }

  @Override
  public Key delete() {
    return delMax();
  }

  public Key delMax() {
    int max = 0;
    for (int i = 1; i < this.n; i++) {
      if (less(max, i)) {
        max = i;
      }
    }
    exch(max, this.n - 1);

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

  @Override
  public Key[] getPq() {
    return this.pq;
  }
}
