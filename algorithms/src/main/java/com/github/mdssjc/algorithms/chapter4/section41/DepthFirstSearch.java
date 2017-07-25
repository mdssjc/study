package com.github.mdssjc.algorithms.chapter4.section41;

import com.github.mdssjc.algorithms.datastructure.graph.Graph;

/**
 * Depth First Search Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class DepthFirstSearch {

  private final boolean[] marked;
  private int count;

  public DepthFirstSearch(final Graph G, final int s) {
    this.marked = new boolean[G.v()];
    dfs(G, s);
  }

  private void dfs(final Graph G, final int v) {
    this.marked[v] = true;
    this.count++;
    for (final int w : G.adj(v)) {
      if (!this.marked[w]) {
        dfs(G, w);
      }
    }
  }

  public boolean marked(final int w) {
    return this.marked[w];
  }

  public int count() {
    return this.count;
  }
}
