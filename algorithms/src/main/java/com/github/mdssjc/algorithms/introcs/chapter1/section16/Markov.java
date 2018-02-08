package com.github.mdssjc.algorithms.introcs.chapter1.section16;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 1.6.3 Mixing a Markov chain.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = "20", input = {
    "5", "5",
    "0.02000", "0.92000", "0.02000", "0.02000", "0.02000",
    "0.02000", "0.02000", "0.38000", "0.38000", "0.20000",
    "0.02000", "0.02000", "0.02000", "0.92000", "0.02000",
    "0.92000", "0.02000", "0.02000", "0.02000", "0.02000",
    "0.47000", "0.02000", "0.47000", "0.02000", "0.02000"
})
@TestDrive(value = "40", input = {
    "5", "5",
    "0.02000", "0.92000", "0.02000", "0.02000", "0.02000",
    "0.02000", "0.02000", "0.38000", "0.38000", "0.20000",
    "0.02000", "0.02000", "0.02000", "0.92000", "0.02000",
    "0.92000", "0.02000", "0.02000", "0.02000", "0.02000",
    "0.47000", "0.02000", "0.47000", "0.02000", "0.02000"
})
public class Markov {

  public static void main(final String[] args) {
    Executor.execute(Markov.class, args);

    final int trials = Integer.parseInt(args[0]);
    final int n = StdIn.readInt();
    StdIn.readInt();

    final double[][] p = new double[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        p[i][j] = StdIn.readDouble();
      }
    }

    final double[] ranks = new double[n];
    ranks[0] = 1.0;
    for (int t = 0; t < trials; t++) {
      final double[] newRanks = new double[n];
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          newRanks[j] += ranks[k] * p[k][j];
        }
      }
      for (int j = 0; j < n; j++) {
        ranks[j] = newRanks[j];
      }
    }

    for (int i = 0; i < n; i++) {
      StdOut.printf("%8.5f", ranks[i]);
    }
    StdOut.println();
  }
}
