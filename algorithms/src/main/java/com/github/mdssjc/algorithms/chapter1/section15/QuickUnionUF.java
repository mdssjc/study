package com.github.mdssjc.algorithms.chapter1.section15;

/**
 * Quick Union UF.
 *
 * @author Marcelo dos Santos
 *
 */
public class QuickUnionUF extends UnionFind {

  public QuickUnionUF(final int n) {
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
      p = this.id[p];
    }
    return p;
  }
}
