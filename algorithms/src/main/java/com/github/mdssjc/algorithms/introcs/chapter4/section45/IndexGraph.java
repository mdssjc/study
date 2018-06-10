package com.github.mdssjc.algorithms.introcs.chapter4.section45;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.5.2 Using a graph to invert an index.
 * <p>
 * Compilation:  javac IndexGraph.java
 * Dependencies: Graph.java In.java
 * Execution:    java IndexGraph movies.txt "/"
 * Data files:   https://introcs.cs.princeton.edu/45graph/tinyGraph.txt
 *               https://introcs.cs.princeton.edu/45graph/movies.txt
 *               https://introcs.cs.princeton.edu/45graph/amino.csv
 * <p>
 * Builds a graph, then accepts vertex names from standard input
 * and prints its neighbors.
 * <p>
 * % java IndexGraph tinyGraph.txt " "
 * C
 *   A
 *   B
 *   G
 * A
 *   B
 *   C
 *   G
 *   H
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = {"tinyGraph.txt", " "}, input = {"C", "A"})
public class IndexGraph {

  public static void main(final String[] args) {
    Executor.execute(IndexGraph.class, args);

    final var filename = args[0];
    final var delimiter = args[1];
    final var G = new Graph(filename, delimiter);

    while (!StdIn.isEmpty()) {
      final var v = StdIn.readLine();
      if (G.hasVertex(v)) {
        for (final var w : G.adjacentTo(v)) {
          StdOut.println("  " + w);
        }
      }
    }
  }
}
