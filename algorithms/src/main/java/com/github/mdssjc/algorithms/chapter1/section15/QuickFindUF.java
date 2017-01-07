package com.github.mdssjc.algorithms.chapter1.section15;

/**
 * Quick Find UF.
 *
 * @author Marcelo dos Santos
 *
 */
public class QuickFindUF extends UnionFind {

  public QuickFindUF(final int n) {
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
