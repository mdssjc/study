package com.github.mdssjc.algorithms.datastructure.union_find.concrete;

import com.github.mdssjc.algorithms.datastructure.union_find.UnionFind;

/**
 * Weighted Quick Union com Path Compression.
 * <p>
 * Aproximação: Lazy
 * <p>
 * Initialize: N
 * Union: lgN*
 * Find: lgN
 * Connected: lgN
 *
 * @author Marcelo dos Santos
 *
 */
public class WeightedQuickUnionPathCompression extends UnionFind {

  private final int[] sz;

  public WeightedQuickUnionPathCompression(final int n) {
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
      this.id[p] = this.id[this.id[p]];
      p = this.id[p];
    }
    return p;
  }
}
