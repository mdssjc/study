package com.github.mdssjc.algorithms.chapter4.section41;

import com.github.mdssjc.algorithms.datastructure.graph.Graph;

/**
 * Connected Components Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class CCImpl implements CC {

  private final boolean[] marked;
  private final int[] id;
  private int count;

  public CCImpl(final Graph g) {
    this.marked = new boolean[g.v()];
    this.id = new int[g.v()];
    for (int s = 0; s < g.v(); s++) {
      if (!this.marked[s]) {
        dfs(g, s);
        this.count++;
      }
    }
  }

  private void dfs(final Graph g, final int v) {
    this.marked[v] = true;
    this.id[v] = this.count;
    for (final int w : g.adj(v)) {
      if (!this.marked[w]) {
        dfs(g, w);
      }
    }
  }

  @Override
  public boolean connected(final int v, final int w) {
    return this.id[v] == this.id[w];
  }

  @Override
  public int id(final int v) {
    return this.id[v];
  }

  @Override
  public int count() {
    return this.count;
  }
}
