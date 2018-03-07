package com.github.mdssjc.algorithms.introcs.chapter2.section24;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 2.4.4 Percolation probability estimate.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"20", "0.05", "10", "0.0"})
@TestDrive({"20", "0.95", "10", "1.0"})
@TestDrive({"20", "0.85", "10", "0.7"})
@TestDrive({"20", "0.85", "1000", "0.564"})
@TestDrive({"40", "0.85", "100", "0.1"})
public class PercolationProbability {

  public static double estimate(final int n, final double p, final int trials) {
    int count = 0;
    for (int t = 0; t < trials; t++) {
      final boolean[][] isOpen = Percolation.random(n, p);
      if (Percolation.percolates(isOpen)) {
        count++;
      }
    }
    return (double) count / trials;
  }

  public static void main(final String[] args) {
    Executor.execute(PercolationProbability.class, args);

    final int n = Integer.parseInt(args[0]);
    final double p = Double.parseDouble(args[1]);
    final int trials = Integer.parseInt(args[2]);
    final double q = estimate(n, p, trials);
    StdOut.println(q);
  }
}
