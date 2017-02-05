package com.github.mdssjc.algorithms.datastructure.union_find.concrete;

import com.github.mdssjc.algorithms.datastructure.union_find.UnionFind;

/**
 * Quick Find O(MN).
 * <p>
 * Aproximação: Eager
 * <p>
 * Initialize: N
 * Union: N
 * Find: 1
 * Connected: 1
 *
 * @author Marcelo dos Santos
 *
 */
public class QuickFind extends UnionFind {

  public QuickFind(final int n) {
    super(n);
  }

  @Override
  public void union(final int p, final int q) {
    final int pID = find(p);
    final int qID = find(q);
    if (pID == qID) return;
    for (int i = 0; i < this.id.length; i++) {
      if (this.id[i] == pID) {
        this.id[i] = qID;
      }
    }
    this.count--;
  }

  @Override
  public int find(final int p) {
    return this.id[p];
  }
}
