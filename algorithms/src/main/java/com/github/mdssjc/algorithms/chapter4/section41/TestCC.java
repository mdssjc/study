package com.github.mdssjc.algorithms.chapter4.section41;

import com.github.mdssjc.algorithms.datastructure.graph.Graph;
import com.github.mdssjc.algorithms.datastructure.graph.concrete.UndirectedGraph;
import com.github.mdssjc.algorithms.datastructure.queue.Queue;
import com.github.mdssjc.algorithms.datastructure.queue.concrete.ResizingArrayQueue;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Test Connected Components Class.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = "tinyG.txt", valueFile = true)
public class TestCC {

  public static void main(final String[] args) {
    Executor.execute(TestCC.class, args);

    final Graph g = new UndirectedGraph(new In(args[0]));
    final CC cc = new CCImpl(g);

    final int m = cc.count();
    StdOut.println(m + " components");

    final Queue<Integer>[] components;
    components = (Queue<Integer>[]) new Queue[m];
    for (int i = 0; i < m; i++) {
      components[i] = new ResizingArrayQueue<>();
    }
    for (int v = 0; v < g.v(); v++) {
      components[cc.id(v)].enqueue(v);
    }
    for (int i = 0; i < m; i++) {
      for (final int v : components[i]) {
        StdOut.print(v + " ");
      }
      StdOut.println();
    }
  }
}
