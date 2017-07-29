package com.github.mdssjc.algorithms.chapter4.section41;

import com.github.mdssjc.algorithms.datastructure.graph.Graph;

/**
 * TwoColor Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class TwoColor {

  private final boolean[] marked;
  private final boolean[] color;
  private boolean isTwoColorable = true;

  public TwoColor(final Graph g) {
    this.marked = new boolean[g.v()];
    this.color = new boolean[g.v()];
    for (int s = 0; s < g.v(); s++) {
      if (!this.marked[s]) {
        dfs(g, s);
      }
    }
  }

  private void dfs(final Graph g, final int v) {
    this.marked[v] = true;
    for (final int w : g.adj(v)) {
      if (!this.marked[w]) {
        this.color[w] = !this.color[v];
        dfs(g, w);
      } else if (this.color[w] == this.color[v]) {
        this.isTwoColorable = false;
      }
    }
  }

  public boolean isBipartite() {
    return this.isTwoColorable;
  }
}
