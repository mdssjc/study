package com.github.mdssjc.algorithms.datastructure.priority_queue.concrete;

import com.github.mdssjc.algorithms.datastructure.priority_queue.PriorityQueue;

/**
 * Implementação MaxPQ de Priority Queue.
 *
 * @author Marcelo dos Santos
 *
 * @param <Key>
 *     Tipo da chave
 */
public class MaxPQ<Key extends Comparable<Key>> implements PriorityQueue<Key> {

  private final Key[] pq;
  private int N = 0;

  public MaxPQ(final int maxN) {
    this.pq = (Key[]) new Comparable[maxN + 1];
  }

  @Override
  public void insert(final Key v) {
    this.pq[++this.N] = v;
    swim(this.N);
  }

  @Override
  public Key delMax() {
    final Key max = this.pq[1];
    exch(1, this.N--);
    this.pq[this.N + 1] = null;
    sink(1);
    return max;
  }

  @Override
  public Key max() {
    return this.pq[1];
  }

  @Override
  public boolean isEmpty() {
    return this.N == 0;
  }

  @Override
  public int size() {
    return this.N;
  }

  @Override
  public Key[] getPq() {
    return this.pq;
  }
}
