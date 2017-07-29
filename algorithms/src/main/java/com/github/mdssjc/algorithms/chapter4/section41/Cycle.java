package com.github.mdssjc.algorithms.chapter4.section41;

import com.github.mdssjc.algorithms.datastructure.graph.Graph;

/**
 * Cycle Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Cycle {

  private final boolean[] marked;
  private boolean hasCycle;

  public Cycle(final Graph g) {
    this.marked = new boolean[g.v()];
    for (int s = 0; s < g.v(); s++)
      if (!this.marked[s])
        dfs(g, s, s);
  }

  private void dfs(final Graph g, final int v, final int u) {
    this.marked[v] = true;
    for (final int w : g.adj(v))
      if (!this.marked[w])
        dfs(g, w, v);
      else if (w != u) this.hasCycle = true;
  }

  public boolean hasCycle() {
    return this.hasCycle;
  }
}
