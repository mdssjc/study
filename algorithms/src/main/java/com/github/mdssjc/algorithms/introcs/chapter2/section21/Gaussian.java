package com.github.mdssjc.algorithms.introcs.chapter2.section21;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 2.1.2 Gaussian functions.
 * <p>
 * Compilation:  javac Gaussian.java
 * Execution:    java Gaussian x mu sigma
 * <p>
 * Function to compute the Gaussian pdf (probability density function)
 * and the Gaussian cdf (cumulative density function)
 * <p>
 * % java Gaussian 820 1019 209
 * 0.17050966869132111
 * <p>
 * % java Gaussian 1500 1019 209
 * 0.9893164837383883
 * <p>
 * % java Gaussian 1500 1025 231
 * 0.9801220907365489
 * <p>
 * The approximation is accurate to absolute error less than 8 * 10^(-16).
 * Reference: Evaluating the Normal Distribution by George Marsaglia.
 * http://www.jstatsoft.org/v11/a04/paper
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
    var sum = 0.0;
    var term = z;
    for (var i = 3; sum + term != sum; i += 2) {
      sum += term;
      term = term * z * z / i;
    }
    return 0.5 + sum * pdf(z);
  }

  public static double cdf(final double z, final double mu, final double sigma) {
    return cdf((z - mu) / sigma);
  }

  public static double inverseCDF(final double y) {
    return inverseCDF(y, 0.00000001, -8, 8);
  }

  private static double inverseCDF(final double y, final double delta, final double lo, final double hi) {
    final var mid = lo + (hi - lo) / 2;
    if (hi - lo < delta) {
      return mid;
    }
    if (cdf(mid) > y) {
      return inverseCDF(y, delta, lo, mid);
    } else {
      return inverseCDF(y, delta, mid, hi);
    }
  }

  @Deprecated
  public static double phi(final double x) {
    return pdf(x);
  }

  @Deprecated
  public static double phi(final double x, final double mu, final double sigma) {
    return pdf(x, mu, sigma);
  }

  @Deprecated
  public static double Phi(final double z) {
    return cdf(z);
  }

  @Deprecated
  public static double Phi(final double z, final double mu, final double sigma) {
    return cdf(z, mu, sigma);
  }

  @Deprecated
  public static double PhiInverse(final double y) {
    return inverseCDF(y);
  }

  public static void main(final String[] args) {
    Executor.execute(Gaussian.class, args);

    final var z = Double.parseDouble(args[0]);
    final var mu = Double.parseDouble(args[1]);
    final var sigma = Double.parseDouble(args[2]);
    StdOut.println(cdf(z, mu, sigma));
    final var y = cdf(z);
    StdOut.println(inverseCDF(y));
  }
}
