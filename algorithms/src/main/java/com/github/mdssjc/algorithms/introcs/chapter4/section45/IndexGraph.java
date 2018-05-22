package com.github.mdssjc.algorithms.introcs.chapter4.section45;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.5.2 Using a graph to invert an index.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = {"tinyGraph.txt", " "}, input = {"C", "A"})
public class IndexGraph {

  public static void main(final String[] args) {
    Executor.execute(IndexGraph.class, args);

    final String filename = args[0];
    final String delimiter = args[1];
    final Graph G = new Graph(filename, delimiter);

    while (StdIn.hasNextLine()) {
      final String v = StdIn.readLine();
      for (final String w : G.adjacentTo(v)) {
        StdOut.println(" " + w);
      }
    }
  }
}
