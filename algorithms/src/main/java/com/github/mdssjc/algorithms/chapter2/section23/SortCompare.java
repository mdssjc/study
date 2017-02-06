package com.github.mdssjc.algorithms.chapter2.section23;

import com.github.mdssjc.algorithms.sort.Sort;
import com.github.mdssjc.algorithms.sort.concrete.QuickSort;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * SortCompare Class.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"Quick", "Quick3way", "1000000", "100"})
public class SortCompare {

  public static double time(final String alg, final Comparable[] a) {
    final Stopwatch timer = new Stopwatch();
    if (alg.equals("Quick")) {
      final Sort sort = new QuickSort();
      sort.sort(a);
    }
    if (alg.equals("Quick3way")) {
      final Sort sort = new Quick3way();
      sort.sort(a);
    }
    return timer.elapsedTime();
  }

  public static double timeRandomInput(final String alg, final int n, final int t) {
    double total = 0.0;
    final Integer[] a = new Integer[n];
    for (int x = 0; x < t; x++) {
      for (int i = 0; i < n; i++) {
        a[i] = StdRandom.uniform(0,10);
      }
      total += time(alg, a);
    }
    return total;
  }

  public static void main(final String[] args) {
    Executor.execute(SortCompare.class, args);

    final String alg1 = args[0];
    final String alg2 = args[1];
    final int n = Integer.parseInt(args[2]);
    final int t = Integer.parseInt(args[3]);
    final double t1 = timeRandomInput(alg1, n, t); // total for alg1
    final double t2 = timeRandomInput(alg2, n, t); // total for alg2
    StdOut.printf("For %d random Doubles\n %s is", n, alg1);
    StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
  }
}
