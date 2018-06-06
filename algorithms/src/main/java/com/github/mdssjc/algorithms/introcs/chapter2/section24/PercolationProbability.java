package com.github.mdssjc.algorithms.introcs.chapter2.section24;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 2.4.4 Percolation probability estimate.
 * <p>
 * Compilation:  javac PercolationProbability.java
 * Execution:    java PercolationProbability n p trials
 * Dependencies: Percolation.java StdOut.java
 * <p>
 * Repeatedly generated n-by-n boolean matrices, where each site
 * is true with probability p, and compute the probability that
 * the system percolates.
 * <p>
 * % java PercolationProbability 32 0.4 10000
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"2", "0.4", "10000"})
public class PercolationProbability {

  public static double evaluate(final int n, final double p, final int trials) {
    var count = 0;
    for (var t = 0; t < trials; t++) {
      final var isOpen = Percolation.random(n, p);
      if (Percolation.percolates(isOpen)) {
        count++;
      }
    }
    return (double) count / trials;
  }

  public static void main(final String[] args) {
    Executor.execute(PercolationProbability.class, args);

    final var n = Integer.parseInt(args[0]);
    final var p = Double.parseDouble(args[1]);
    final var trials = Integer.parseInt(args[2]);
    final var q = evaluate(n, p, trials);
    StdOut.println(q);
  }
}
