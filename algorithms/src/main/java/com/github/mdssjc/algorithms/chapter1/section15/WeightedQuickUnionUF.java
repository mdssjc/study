package com.github.mdssjc.algorithms.chapter1.section15;

/**
 * Weighted Quick Union UF.
 *
 * @author Marcelo dos Santos
 *
 */
public class WeightedQuickUnionUF extends UnionFind {

  private final int[] sz;

  public WeightedQuickUnionUF(final int n) {
    super(n);
    this.sz = new int[n];
    for (int i = 0; i < n; i++) {
      this.sz[i] = 1;
    }
  }

  @Override
  public void union(final int p, final int q) {
    final int i = find(p);
    final int j = find(q);
    if (i == j) {
      return;
    }
    if (this.sz[i] < this.sz[j]) {
      this.id[i] = j;
      this.sz[j] += this.sz[i];
    } else {
      this.id[j] = i;
      this.sz[i] += this.sz[j];
    }
    this.count--;
  }

  @Override
  public int find(int p) {
    while (p != this.id[p]) {
      p = this.id[p];
    }
    return p;
  }
}
