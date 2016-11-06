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
@TestDrive
public class CEx27 {

  private static final Map<String, Double> memoizer = new HashMap<>();
  private static int counter = 0;

  public static void main(final String[] args) {
    Executor.execute(CEx27.class, args);

    final double binomial = binomial(100, 50, 0.25);
    StdOut.println(binomial);
    StdOut.println("Calls: " + CEx27.counter);
  }

  private static double binomial(final int N, final int k, final double p) {
    final String key = String.format("%d|%d", N, k);
    if (CEx27.memoizer.containsKey(key)) {
      return CEx27.memoizer.get(key);
    }

    CEx27.counter++;

    if ((N == 0) && (k == 0)) {
      return 1.0;
    }
    if ((N < 0) || (k < 0)) {
      return 0.0;
    }

    final double value = (1 - p) * binomial(N - 1, k, p)
        + p * binomial(N - 1, k - 1, p);

    CEx27.memoizer.put(key, value);
    return value;
  }
}
