package com.github.mdssjc.algorithms.introcs.chapter2.section22;

import com.github.mdssjc.algorithms.introcs.chapter2.section21.Gaussian;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdDraw;

/**
 * Program 2.2.6 Bernoulli trials.
 * <p>
 * Compilation:  javac Bernoulli.java
 * Execution:    java Bernoulli n trials
 * Dependencies: StdDraw.java StdRandom.java Gaussian.java StdStats.java
 * <p>
 * Each experiment consists of flipping n fair coins trials times.
 * Plots a histogram of the number of times i of the n coins are heads.
 * <p>
 * % java Bernoulli 32 1000
 * <p>
 * % java Bernoulli 64 1000
 * <p>
 * % java Bernoulli 128 1000
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"32", "1000"})
@TestDrive({"64", "1000"})
@TestDrive({"128", "1000"})
public class Bernoulli {

  public static int binomial(final int n, final double p) {
    var heads = 0;
    for (var i = 0; i < n; i++) {
      if (StdRandom.bernoulli(p)) {
        heads++;
      }
    }
    return heads;
  }

  public static int binomial(final int n) {
    var heads = 0;
    for (var i = 0; i < n; i++) {
      if (StdRandom.bernoulli(0.5)) {
        heads++;
      }
    }
    return heads;
  }

  public static void main(final String[] args) {
    Executor.execute(Bernoulli.class, args);

    final var n = Integer.parseInt(args[0]);
    final var trials = Integer.parseInt(args[1]);

    StdDraw.setYscale(0, 0.2);

    final var freq = new int[n + 1];
    for (var t = 0; t < trials; t++) {
      freq[binomial(n)]++;
    }

    final var normalized = new double[n + 1];
    for (var i = 0; i <= n; i++) {
      normalized[i] = (double) freq[i] / trials;
    }
    StdStats.plotBars(normalized);

    final var mean = n / 2.0;
    final var stddev = Math.sqrt(n) / 2.0;
    final var phi = new double[n + 1];
    for (var i = 0; i <= n; i++) {
      phi[i] = Gaussian.pdf(i, mean, stddev);
    }
    StdStats.plotLines(phi);
  }
}
