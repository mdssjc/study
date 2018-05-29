package com.github.mdssjc.algorithms.introcs.chapter4.section45;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.5.6 Performer–performer graph.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"tinyMovies.txt", "/"})
@TestDrive({"moviesG.txt", "/"})
public class Performer {

  public static void main(final String[] args) {
    Executor.execute(Performer.class, args);

    final String filename = args[0];
    final String delimiter = args[1];
    final Graph G = new Graph();

    final In in = new In(filename);
    while (in.hasNextLine()) {
      final String line = in.readLine();
      final String[] names = line.split(delimiter);
      for (int i = 1; i < names.length; i++) {
        for (int j = i + 1; j < names.length; j++) {
          G.addEdge(names[i], names[j]);
        }
      }
    }

    final double degree = SmallWorld.averageDegree(G);
    final double length = SmallWorld.averagePathLength(G);
    final double cluster = SmallWorld.clusteringCoefficient(G);
    StdOut.printf("number of vertices     = %7d%n", G.V());
    StdOut.printf("average degree         = %7.3f%n", degree);
    StdOut.printf("average path length    = %7.3f%n", length);
    StdOut.printf("clustering coefficient = %7.3f%n", cluster);
  }
}
