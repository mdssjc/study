package com.github.mdssjc.algorithms.introcs.chapter4.section45;

import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.5.3 Shortest-paths client.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = {"routes.txt", " ", "JFK"}, input = {"LAX", "DFW"})
public class PathFinder {

  public static void main(final String[] args) {

    final String filename = args[0];
    final String delimiter = args[1];
    final Graph G = new Graph(filename, delimiter);
    final String s = args[2];
    final PathFinder pf = new PathFinder(G, s);

    while (StdIn.hasNextLine()) {
      final String t = StdIn.readLine();
      final int d = pf.distanceTo(t);
      for (final String v : pf.pathTo(t)) {
        StdOut.println(" " + v);
      }
      StdOut.println("distance " + d);
    }
  }
}
