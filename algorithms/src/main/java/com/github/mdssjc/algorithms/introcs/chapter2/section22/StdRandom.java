package com.github.mdssjc.algorithms.introcs.chapter2.section22;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

import java.util.Random;

/**
 * Program 2.2.1 Random number library.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("5")
public class StdRandom {

  public static int uniform(final int n) {
    return (int) (Math.random() * n);
  }

  public static double uniform(final double lo, final double hi) {
    return lo + Math.random() * (hi - lo);
  }

  public static boolean bernoulli(final double p) {
    return Math.random() < p;
  }

  public static double gaussian() {
    double r, x, y;
    do {
      x = uniform(-1.0, 1.0);
      y = uniform(-1.0, 1.0);
      r = x * x + y * y;
    } while (r >= 1 || r == 0);
    return x * Math.sqrt(-2 * Math.log(r) / r);
  }

  public static double gaussian(final double mu, final double sigma) {
    return mu + sigma * gaussian();
  }

  public static int discrete(final double[] probabilities) {
    double sum = 0.0;
    for (int i = 0; i < probabilities.length; i++) {
      sum += probabilities[i];
    }

    final Random random = new Random();
    while (true) {
      final double r = random.nextDouble();
      sum = 0.0;
      for (int i = 0; i < probabilities.length; i++) {
        sum = sum + probabilities[i];
        if (sum > r) {
          return i;
        }
      }
    }
  }

  public static void shuffle(final double[] a) {
    final int n = a.length;
    for (int i = 0; i < n; i++) {
      final int r = i + uniform(n - i);
      final double temp = a[i];
      a[i] = a[r];
      a[r] = temp;
    }
  }

  public static void main(final String[] args) {
    Executor.execute(StdRandom.class, args);

    final int n = Integer.parseInt(args[0]);

    final double[] probabilities = {0.5, 0.3, 0.1, 0.1};
    for (int i = 0; i < n; i++) {
      StdOut.printf("%2d ", uniform(100));
      StdOut.printf("%8.5f ", uniform(10.0, 99.0));
      StdOut.printf("%5b ", bernoulli(0.5));
      StdOut.printf("%8.5f ", gaussian());
      StdOut.printf("%1d ", discrete(probabilities));
      StdOut.println();
    }
  }
}
