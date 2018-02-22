package com.github.mdssjc.algorithms.introcs.chapter2.section22;

import com.github.mdssjc.algorithms.introcs.chapter2.section21.Gaussian;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 2.2.6 Bernoulli trials.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"20", "100000"})
public class Bernoulli {

  public static int binomial(final int n) {
    int heads = 0;
    for (int i = 0; i < n; i++) {
      if (StdRandom.bernoulli(0.5)) {
        heads++;
      }
    }
    return heads;
  }

  public static void main(final String[] args) {
    Executor.execute(Bernoulli.class, args);

    final int n = Integer.parseInt(args[0]);
    final int trials = Integer.parseInt(args[1]);

    final int[] freq = new int[n + 1];
    for (int t = 0; t < trials; t++) {
      freq[binomial(n)]++;
    }

    final double[] norm = new double[n + 1];
    for (int i = 0; i <= n; i++) {
      norm[i] = (double) freq[i] / trials;
    }
    StdStats.plotBars(norm);

    final double mean = n / 2.0;
    final double stddev = Math.sqrt(n) / 2.0;
    final double[] phi = new double[n + 1];
    for (int i = 0; i <= n; i++) {
      phi[i] = Gaussian.pdf(i, mean, stddev);
    }
    StdStats.plotLines(phi);
  }
}
