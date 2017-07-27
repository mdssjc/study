package com.github.mdssjc.algorithms.chapter4.section41;

import com.github.mdssjc.algorithms.datastructure.graph.Graph;

/**
 * Depth First Search Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class DepthFirstSearch implements Search {

  private final boolean[] marked;
  private int count;

  public DepthFirstSearch(final Graph g, final int s) {
    this.marked = new boolean[g.v()];
    dfs(g, s);
  }

  private void dfs(final Graph g, final int v) {
    this.marked[v] = true;
    this.count++;
    for (final int w : g.adj(v)) {
      if (!this.marked[w]) {
        dfs(g, w);
      }
    }
  }

  @Override
  public boolean marked(final int v) {
    return this.marked[v];
  }

  @Override
  public int count() {
    return this.count;
  }
}
