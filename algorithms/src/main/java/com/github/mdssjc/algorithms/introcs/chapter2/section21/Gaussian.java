package com.github.mdssjc.algorithms.introcs.chapter2.section21;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 2.1.2 Gaussian functions.
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

  public static void main(final String[] args) {
    Executor.execute(Gaussian.class, args);

    final double z = Double.parseDouble(args[0]);
    final double mu = Double.parseDouble(args[1]);
    final double sigma = Double.parseDouble(args[2]);
    StdOut.printf("%.3f%n", cdf((z - mu) / sigma));
  }
}
