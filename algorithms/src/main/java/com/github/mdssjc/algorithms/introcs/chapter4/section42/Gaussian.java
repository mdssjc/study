package com.github.mdssjc.algorithms.introcs.chapter4.section42;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.2.2 Bisection search.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"820", "1019", "209"})
@TestDrive({"1500", "1019", "209"})
@TestDrive({"1500", "1025", "231"})
public class Gaussian {

  public static double pdf(final double x) {
    return Math.exp(-x * x / 2) / Math.sqrt(2 * Math.PI);
  }

  public static double pdf(final double x, final double mu, final double sigma) {
    return pdf((x - mu) / sigma) / sigma;
  }

  public static double cdf(final double z) {
    if (z < -8.0) {
      return 0.0;
    }
    if (z > 8.0) {
      return 1.0;
    }
    double sum = 0.0;
    double term = z;
    for (int i = 3; sum != sum + term; i += 2) {
      sum = sum + term;
      term = term * z * z / i;
    }
    return 0.5 + pdf(z) * sum;
  }

  public static double inverseCDF(final double y) {
    return bisectionSearch(y, 0.00000001, -8, 8);
  }

  private static double bisectionSearch(final double y, final double delta,
                                        final double lo, final double hi) {
    final double mid = lo + (hi - lo) / 2;
    if (hi - lo < delta) {
      return mid;
    }
    if (cdf(mid) > y) {
      return bisectionSearch(y, delta, lo, mid);
    } else {
      return bisectionSearch(y, delta, mid, hi);
    }
  }

  public static void main(final String[] args) {
    Executor.execute(Gaussian.class, args);

    final double z = Double.parseDouble(args[0]);
    final double mu = Double.parseDouble(args[1]);
    final double sigma = Double.parseDouble(args[2]);
    StdOut.printf("%.3f%n", cdf((z - mu) / sigma));

    final double y = cdf(z);
    StdOut.println(inverseCDF(y));
  }
}
