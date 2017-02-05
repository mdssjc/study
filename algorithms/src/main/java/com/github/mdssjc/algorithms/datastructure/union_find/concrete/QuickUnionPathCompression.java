package com.github.mdssjc.algorithms.datastructure.union_find.concrete;

import com.github.mdssjc.algorithms.datastructure.union_find.UnionFind;

/**
 * Quick Union com Path Compression O(N+MlogN).
 * <p>
 * Aproximação: Lazy
 * <p>
 * Initialize: N
 * Union: N*
 * Find: N
 * Connected: N
 *
 * @author Marcelo dos Santos
 *
 */
public class QuickUnionPathCompression extends UnionFind {

  public QuickUnionPathCompression(final int n) {
    super(n);
  }

  @Override
  public void union(final int p, final int q) {
    final int i = find(p);
    final int j = find(q);
    if (i == j) {
      return;
    }
    this.id[i] = j;
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
