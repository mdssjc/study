package com.github.mdssjc.algorithms.chapter2.section21;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.*;

/**
 * SortCompare Class.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( {"Insertion", "Selection", "1000", "100"} )
public class SortCompare {

  public static double time(final String alg, final Comparable[] a) {
    final Stopwatch timer = new Stopwatch();
    if (alg.equals("Insertion")) {
      Insertion.sort(a);
    }
    if (alg.equals("Selection")) {
      Selection.sort(a);
    }
    if (alg.equals("Shell")) {
      Shell.sort(a);
    }
    if (alg.equals("Merge")) {
      Merge.sort(a);
    }
    if (alg.equals("Quick")) {
      Quick.sort(a);
    }
    if (alg.equals("Heap")) {
      Heap.sort(a);
    }
    return timer.elapsedTime();
  }

  public static double timeRandomInput(final String alg, final int n, final int t) {
    // Use alg to sort T random arrays of length N.
    double total = 0.0;
    final Double[] a = new Double[n];
    for (int x = 0; x < t; x++) {
      // Perform one experiment (generate and sort an array).
      for (int i = 0; i < n; i++) {
        a[i] = StdRandom.uniform();
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
