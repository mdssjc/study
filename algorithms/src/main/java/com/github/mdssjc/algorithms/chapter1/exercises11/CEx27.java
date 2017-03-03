package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.Map;

/**
 * Creative Exercise 27.
 * <p>
 * Binomial distribution.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"100", "50", "0.25"})
public class CEx27 {

  private static final Map<String, Double> memoizer = new HashMap<>();
  private static int counter = 0;

  public static void main(final String[] args) {
    Executor.execute(CEx27.class, args);

    final int n = Integer.parseInt(args[0]);
    final int k = Integer.parseInt(args[1]);
    final double p = Double.parseDouble(args[2]);

    final double binomial = binomial(n, k, p);
    StdOut.println(binomial);
    StdOut.println("Calls: " + CEx27.counter);
  }

  private static double binomial(final int n, final int k, final double p) {
    final String key = String.format("%d|%d", n, k);
    if (CEx27.memoizer.containsKey(key)) {
      return CEx27.memoizer.get(key);
    }

    CEx27.counter++;

    if ((n == 0) && (k == 0)) {
      return 1.0;
    }
    if ((n < 0) || (k < 0)) {
      return 0.0;
    }

    final double value = (1 - p) * binomial(n - 1, k, p)
                         + p * binomial(n - 1, k - 1, p);

    CEx27.memoizer.put(key, value);
    return value;
  }
}
