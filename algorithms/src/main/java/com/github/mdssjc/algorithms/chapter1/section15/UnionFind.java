package com.github.mdssjc.algorithms.chapter1.section15;

/**
 * Union Find (UF).
 *
 * @author Marcelo dos Santos
 *
 */
public abstract class UnionFind implements UF {

  protected int[] id;
  protected int count;

  /**
   * Initialize N sites with integer names ( 0 to N-1).
   *
   * @param n
   *     Sites
   */
  public UnionFind(final int n) {
    this.count = n;
    this.id = new int[n];
    for (int i = 0; i < n; i++) {
      this.id[i] = i;
    }
  }

  @Override
  public int count() {
    return this.count;
  }
}
