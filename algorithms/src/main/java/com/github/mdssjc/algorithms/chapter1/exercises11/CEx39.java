package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.chapter1.section11.BinarySearch;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
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
@TestDrive( "10" )
public class CEx39 {

  public static void main(final String[] args) {
    Executor.execute(CEx39.class, args);

    final int t = Integer.parseInt(args[0]);
    final int[] experiments = {1_000, 10_000, 100_000, 1_000_000};

    for (final int experiment : experiments) {
      final double average = runTrial(t, experiment);
      StdOut.printf("Average of %6.2f over the %d trials for each value of N(%d)%n",
                    average, t, experiment);
    }
  }

  private static double runTrial(final int trials, final int experiment) {
    int times = 0;

    final int[] a = new int[experiment];
    final int[] b = new int[experiment];

    for (int trial = 0; trial < trials; trial++) {
      init(a);
      init(b);

      for (int i = 0; i < experiment; i++) {
        if (BinarySearch.rank(a[i], b) >= 0) {
          times++;
        }
      }
    }
    return (double) (times) / trials;
  }

  private static void init(final int[] a) {
    for (int i = 0; i < a.length; i++) {
      a[i] = StdRandom.uniform(100_000, 999_999);
    }
  }
}
