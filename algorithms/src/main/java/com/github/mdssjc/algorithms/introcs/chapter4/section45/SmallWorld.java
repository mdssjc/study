package com.github.mdssjc.algorithms.introcs.chapter4.section45;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.5.5 Small-world test.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"tinyGraph.txt", " "})
public class SmallWorld {

  public static double averageDegree(final Graph G) {
    return 2.0 * G.E() / G.V();
  }

  public static double averagePathLength(final Graph G) {
    int sum = 0;
    for (final String v : G.vertices()) {
      final PathFinder pf = new PathFinder(G, v);
      for (final String w : G.vertices()) {
        sum += pf.distanceTo(w);
      }
    }
    return (double) sum / (G.V() * (G.V() - 1));
  }

  public static double clusteringCoefficient(final Graph G) {
    double total = 0.0;
    for (final String v : G.vertices()) {
      final int possible = G.degree(v) * (G.degree(v) - 1);
      int actual = 0;
      for (final String u : G.adjacentTo(v)) {
        for (final String w : G.adjacentTo(v)) {
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

  public static void main(final String[] args) {
    Executor.execute(SmallWorld.class, args);

    final String filename = args[0];
    final String delimiter = args[1];
    final Graph graph = new Graph(filename, delimiter);

    StdOut.printf("%d vertices, %d edges%n", graph.V(), graph.E());
    StdOut.printf("average degree         = %5.3f%n", averageDegree(graph));
    StdOut.printf("average path length    = %5.3f%n", averagePathLength(graph));
    StdOut.printf("clustering coefficient = %5.3f%n",
                  clusteringCoefficient(graph));
  }
}
