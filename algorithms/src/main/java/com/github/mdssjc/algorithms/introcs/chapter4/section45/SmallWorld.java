package com.github.mdssjc.algorithms.introcs.chapter4.section45;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.5.5 Small-world test.
 * <p>
 * Compilation:  javac SmallWorld.java
 * Execution:    java SmallWorld filename delimiter
 * Dependencies: Graph.java PathFinder.java StdOut.java In.java
 * Data files:   https://introcs.cs.princeton.edu/45graph/tinyGraph.txt
 * <p>
 * %  java SmallWorld tinyGraph.txt " "
 * number of vertices     =       5
 * number of edges        =       7
 * average degree         =   2.800
 * maximum degree         =       4
 * average path length    =   1.300
 * clustering coefficient =   0.767
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"tinyGraph.txt", " "})
public class SmallWorld {

  public static double averageDegree(final Graph G) {
    return (double) 2 * G.E() / G.V();
  }

  public static double averagePathLength(final Graph G) {
    var sum = 0;
    for (final var v : G.vertices()) {
      final var pf = new PathFinder(G, v);
      for (final var w : G.vertices()) {
        sum += pf.distanceTo(w);
      }
    }
    return (double) sum / (G.V() * (G.V() - 1));
  }

  public static double clusteringCoefficient(final Graph G) {
    var total = 0.0;
    for (final var v : G.vertices()) {
      final var possible = G.degree(v) * (G.degree(v) - 1);
      var actual = 0;
      for (final var u : G.adjacentTo(v)) {
        for (final var w : G.adjacentTo(v)) {
          if (G.hasEdge(u, w)) {
            actual++;
          }
        }
      }
      if (possible > 0) {
        total += 1.0 * actual / possible;
      }
    }
    return total / G.V();
  }

  public static int maxDegree(final Graph G) {
    var max = 0;
    for (final var v : G.vertices()) {
      if (G.degree(v) > max) {
        max = G.degree(v);
      }
    }
    return max;
  }

  public static void main(final String[] args) {
    Executor.execute(SmallWorld.class, args);

    final var filename = args[0];
    final var delimiter = args[1];
    final var graph = new Graph(filename, delimiter);

    StdOut.printf("number of vertices     = %7d%n", graph.V());
    StdOut.printf("number of edges        = %7d%n", graph.E());
    StdOut.printf("average degree         = %7.3f%n", averageDegree(graph));
    StdOut.printf("maximum degree         = %7d%n", maxDegree(graph));
    StdOut.printf("average path length    = %7.3f%n", averagePathLength(graph));
    StdOut.printf("clustering coefficient = %7.3f%n", clusteringCoefficient(graph));
  }
}
