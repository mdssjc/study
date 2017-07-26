package com.github.mdssjc.algorithms.chapter4.section41;

import com.github.mdssjc.algorithms.datastructure.graph.Graph;
import com.github.mdssjc.algorithms.datastructure.stack.Stack;
import com.github.mdssjc.algorithms.datastructure.stack.concrete.ResizingArrayStack;

/**
 * Depth First Paths Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class DepthFirstPaths implements Paths {

  private final boolean[] marked;
  private final int[] edgeTo;
  private final int s;

  public DepthFirstPaths(final Graph g, final int s) {
    this.marked = new boolean[g.v()];
    this.edgeTo = new int[g.v()];
    this.s = s;
    dfs(g, s);
  }

  private void dfs(final Graph g, final int v) {
    this.marked[v] = true;
    for (final int w : g.adj(v)) {
      if (!this.marked[w]) {
        this.edgeTo[w] = v;
        dfs(g, w);
      }
    }
  }

  @Override
  public boolean hasPathTo(final int v) {
    return this.marked[v];
  }

  @Override
  public Iterable<Integer> pathTo(final int v) {
    if (!hasPathTo(v)) {
      return null;
    }
    final Stack<Integer> path = new ResizingArrayStack<>();
    for (int x = v; x != this.s; x = this.edgeTo[x]) {
      path.push(x);
    }
    path.push(this.s);
    return path;
  }
}
