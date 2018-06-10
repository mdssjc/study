package com.github.mdssjc.algorithms.introcs.chapter4.section45;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.5.6 Performer-performer graph.
 * <p>
 * Compilation:  javac SmallWorld.java
 * Execution:    java SmallWorld filename delimiter
 * Dependencies: Graph.java PathFinder.java StdOut.java In.java
 * Data files:   https://introcs.cs.princeton.edu/45graph/tinyMovies.txt
 * https://introcs.cs.princeton.edu/45graph/moviesG.txt
 * <p>
 * % java Performer tinyMovies.txt "/"
 * number of vertices     =       5
 * average degree         =   2.800
 * average path length    =   1.300
 * clustering coefficient =   0.767
 * <p>
 * % java Performer moviesG.txt "/"
 * [ after a long time ]
 * number of vertices     =   19044
 * average degree         = 148.688
 * average path length    =   3.494
 * clustering coefficient =   0.911
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"tinyMovies.txt", "/"})
@TestDrive({"moviesG.txt", "/"})
public class Performer {

  public static void main(final String[] args) {
    Executor.execute(Performer.class, args);

    final var filename = args[0];
    final var delimiter = args[1];
    final var graph = new Graph();
    final var in = new In(filename);
    while (in.hasNextLine()) {
      final var line = in.readLine();
      final var names = line.split(delimiter);
      for (var i = 1; i < names.length; i++) {
        for (var j = i + 1; j < names.length; j++) {
          graph.addEdge(names[i], names[j]);
        }
      }
    }

    final var degree = SmallWorld.averageDegree(graph);
    final var length = SmallWorld.averagePathLength(graph);
    final var cluster = SmallWorld.clusteringCoefficient(graph);
    StdOut.printf("number of vertices     = %7d%n", graph.V());
    StdOut.printf("average degree         = %7.3f%n", degree);
    StdOut.printf("average path length    = %7.3f%n", length);
    StdOut.printf("clustering coefficient = %7.3f%n", cluster);
  }
}
