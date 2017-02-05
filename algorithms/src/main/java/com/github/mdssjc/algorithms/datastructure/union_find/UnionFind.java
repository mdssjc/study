package com.github.mdssjc.algorithms.datastructure.union_find;

/**
 * Union Find (UF).
 *
 * @author Marcelo dos Santos
 *
 */
public abstract class UnionFind implements UF {

  protected final int[] id;
  protected int count;

  /**
   * Inicializa N sites com nomes inteiros (0 a N-1).
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
