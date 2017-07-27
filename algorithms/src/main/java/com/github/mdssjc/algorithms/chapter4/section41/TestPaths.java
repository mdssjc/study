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

    final Graph g = new UndirectedGraph(new In(args[0]));
    final int s = Integer.parseInt(args[1]);

    System.out.println("Depth First Paths:");
    Paths search = new DepthFirstPaths(g, s);
    test(g, s, search);

    System.out.println("Breadth First Paths:");
    search = new BreadthFirstPaths(g, s);
    test(g, s, search);
  }

  private static void test(final Graph g, final int s, final Paths search) {
    for (int v = 0; v < g.v(); v++) {
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
