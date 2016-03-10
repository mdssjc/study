package com.github.mdssjc.algorithms.exercises.percolation;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * PercolationStats Test Client.
 *
 * @author mdssjc
 *
 */
public class PercolationStats {

  private double[]  results;
  private final int times;

  // perform T independent experiments on an N-by-N grid
  public PercolationStats(final int N, final int T) {
    if (N <= 0 || T <= 0) {
      throw new IllegalArgumentException(
          "Illegal Argument Exception (N <= 0 || T <= 0)");
    }

    this.times = T;
    experiment(N);
  }

  // sample mean of percolation threshold
  public double mean() {
    return StdStats.mean(this.results);
  }

  // sample standard deviation of percolation threshold
  public double stddev() {
    return StdStats.stddev(this.results);
  }

  // returns lower bound of the 95% confidence interval
  public double confidenceLo() {
    return mean() - (1.96 * stddev() / Math.sqrt(this.times));
  }

  // returns upper bound of the 95% confidence interval
  public double confidenceHi() {
    return mean() + (1.96 * stddev() / Math.sqrt(this.times));
  }

  // execution of experiment
  private void experiment(final int N) {
    final int size = N * N;
    this.results = new double[this.times];

    for (int t = 0; t < this.times; t++) {
      int count = 0;

      final Percolation percolation = new Percolation(N);
      while (!percolation.percolates()) {
        final int row = StdRandom.uniform(N) + 1;
        final int col = StdRandom.uniform(N) + 1;
        if (!percolation.isOpen(row, col)) {
          percolation.open(row, col);
          count++;
        }
      }

      this.results[t] = (double) (count) / size;
    }
  }

  // test client
  public static void main(final String[] args) {
    final int n = Integer.parseInt(args[0]);
    final int t = Integer.parseInt(args[1]);

    final PercolationStats p = new PercolationStats(n, t);
    StdOut.println("mean                    = " + p.mean());
    StdOut.println("stddev                  = " + p.stddev());
    StdOut.println("95% confidence interval = " + p.confidenceLo() + ", "
        + p.confidenceHi());
  }
}
