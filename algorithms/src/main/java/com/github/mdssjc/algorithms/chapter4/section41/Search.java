package com.github.mdssjc.algorithms.chapter4.section41;

import com.github.mdssjc.algorithms.datastructure.graph.Graph;
import com.github.mdssjc.algorithms.datastructure.union_find.UF;
import com.github.mdssjc.algorithms.datastructure.union_find.concrete.WeightedQuickUnion;

/**
 * Search Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Search {

  private final UF union;
  private final int s;

  public Search(final Graph g, final int s) {
    this.union = new WeightedQuickUnion(g.e());
    this.s = s;

    for (int i = 0; i < g.e(); i++) {
      for (final int n : g.adj(i)) {
        this.union.union(i, n);
      }
    }
  }

  public boolean marked(final int v) {
    return this.union.connected(this.s, v);
  }

  public int count() {
    // TODO: Exercise 4.1.8
    return 0;
  }
}
