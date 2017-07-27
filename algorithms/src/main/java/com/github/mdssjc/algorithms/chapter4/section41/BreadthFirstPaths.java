package com.github.mdssjc.algorithms.chapter4.section41;

import com.github.mdssjc.algorithms.datastructure.graph.Graph;
import com.github.mdssjc.algorithms.datastructure.queue.Queue;
import com.github.mdssjc.algorithms.datastructure.queue.concrete.ResizingArrayQueue;
import com.github.mdssjc.algorithms.datastructure.stack.Stack;
import com.github.mdssjc.algorithms.datastructure.stack.concrete.ResizingArrayStack;

/**
 * Depth First Paths Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class BreadthFirstPaths implements Paths {

  private final int s;
  private final boolean[] marked;
  private final int[] edgeTo;

  public BreadthFirstPaths(final Graph g, final int s) {
    this.marked = new boolean[g.v()];
    this.edgeTo = new int[g.v()];
    this.s = s;
    bfs(g, s);
  }

  private void bfs(final Graph G, final int s) {
    final Queue<Integer> queue = new ResizingArrayQueue<>();
    this.marked[s] = true;
    queue.enqueue(s);
    while (!queue.isEmpty()) {
      final int v = queue.dequeue();
      for (final int w : G.adj(v))
        if (!this.marked[w]) {
          this.edgeTo[w] = v;
          this.marked[w] = true;
          queue.enqueue(w);
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
