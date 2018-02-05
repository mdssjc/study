package com.github.mdssjc.algorithms.introcs.chapter1.section16;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 1.6.1 Computing the transition matrix.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "tiny.txt", inputFile = true)
public class Transition {

  public static void main(final String[] args) {
    Executor.execute(Transition.class, args);

    final int n = StdIn.readInt();
    final int[][] counts = new int[n][n];
    final int[] outDegrees = new int[n];

    while (!StdIn.isEmpty()) {
      final int i = StdIn.readInt();
      final int j = StdIn.readInt();
      outDegrees[i]++;
      counts[i][j]++;
    }

    StdOut.println(n + " " + n);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        final double p = 0.9 * counts[i][j] / outDegrees[i] + 0.1 / n;
        StdOut.printf("%8.5f", p);
      }
      StdOut.println();
    }
  }
}
