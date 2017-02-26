package com.github.mdssjc.algorithms.datastructure.priority_queue.concrete;

import com.github.mdssjc.algorithms.datastructure.priority_queue.OrderedArrayPQ;

/**
 * Implementação MaxPQ de Priority Queue.
 *
 * @author Marcelo dos Santos
 *
 * @param <Key>
 *     Tipo da chave
 */
public class MaxPQ<Key extends Comparable<Key>> implements OrderedArrayPQ<Key> {

  private final Key[] pq;
  private int n;

  public MaxPQ() {
    this.pq = (Key[]) new Comparable[100];
  }

  public MaxPQ(final int maxN) {
    this.pq = (Key[]) new Comparable[maxN + 1];
  }

  public MaxPQ(final Key[] pq) {
    this.pq = pq;
  }

  @Override
  public void insert(final Key v) {
    this.pq[++this.n] = v;
    swim(this.n);
  }

  @Override
  public Key delete() {
    return delMax();
  }

  public Key max() {
    return this.pq[1];
  }

  public Key delMax() {
    final Key max = this.pq[1];
    exch(1, this.n--);
    this.pq[this.n + 1] = null;
    sink(1);
    return max;
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
