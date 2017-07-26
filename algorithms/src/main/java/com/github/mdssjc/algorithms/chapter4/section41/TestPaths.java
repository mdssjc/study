package com.github.mdssjc.algorithms.chapter4.section41;

import com.github.mdssjc.algorithms.datastructure.graph.Graph;
import com.github.mdssjc.algorithms.datastructure.graph.concrete.UndirectedGraph;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Test Paths Class.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = {"tinyCG.txt", "0"}, valueFile = true)
public class TestPaths {

  public static void main(final String[] args) {
    Executor.execute(TestPaths.class, args);

    final Graph G = new UndirectedGraph(new In(args[0]));
    final int s = Integer.parseInt(args[1]);
    final Paths search = new DepthFirstPaths(G, s);

    for (int v = 0; v < G.v(); v++) {
      StdOut.print(s + " to " + v + ": ");
      if (search.hasPathTo(v)) {
        for (final int x : search.pathTo(v)) {
          if (x == s) {
            StdOut.print(x);
          } else {
            StdOut.print("-" + x);
          }
        }
      }
      StdOut.println();
    }
  }
}
