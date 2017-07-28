package com.github.mdssjc.algorithms.chapter4.section41;

import com.github.mdssjc.algorithms.datastructure.graph.Graph;
import com.github.mdssjc.algorithms.datastructure.graph.concrete.UndirectedGraph;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Test Search Class.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = {"tinyG.txt", "0"}, valueFile = true)
@TestDrive(value = {"tinyG.txt", "9"}, valueFile = true)
public class TestSearch {

  public static void main(final String[] args) {
    Executor.execute(TestSearch.class, args);

    final Graph g = new UndirectedGraph(new In(args[0]));
    final int s = Integer.parseInt(args[1]);
    final Search search = new DepthFirstSearch(g, s);

    for (int v = 0; v < g.v(); v++) {
      if (search.marked(v)) {
        StdOut.print(v + " ");
      }
    }
    StdOut.println();

    if (search.count() != g.v()) {
      StdOut.print("NOT ");
    }
    StdOut.println("connected");
  }
}
