package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Creative Exercise 39.
 * <p>
 * Random matches.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("10")
public class CEx39 {

  public static void main(final String[] args) {
    Executor.execute(CEx39.class, args);

    final int t = Integer.parseInt(args[0]);
    final int[] experiments = {1000, 10000, 100000, 1000000};

    for (final int experiment : experiments) {
      final double average = runTrial(t, experiment);
      StdOut.printf("Average of %6.2f over the %d trials for each value of N(%d)%n",
                    average, t, experiment);
    }
  }

  private static double runTrial(final int trials, final int experiment) {
    final int[] a = new int[experiment];
    final int[] b = new int[experiment];
    int times = 0;

    for (int trial = 0; trial < trials; trial++) {
      init(a);
      init(b);

      for (int i = 0; i < experiment; i++) {
        if (BinarySearch.indexOf(b, a[i]) >= 0) {
          times++;
        }
      }
    }
    return (double) (times) / trials;
  }

  private static void init(final int[] a) {
    for (int i = 0; i < a.length; i++) {
      a[i] = StdRandom.uniform(100000, 1000000);
    }
  }
}
