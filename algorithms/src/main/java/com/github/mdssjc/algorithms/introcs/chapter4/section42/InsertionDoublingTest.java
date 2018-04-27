package com.github.mdssjc.algorithms.introcs.chapter4.section42;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.Stopwatch;

/**
 * Program 4.2.5 Doubling test for insertion sort.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("1")
@TestDrive("10")
public class InsertionDoublingTest {

  public static double timeTrials(final int trials, final int n) {
    double total = 0.0;
    final Double[] a = new Double[n];
    for (int t = 0; t < trials; t++) {
      for (int i = 0; i < n; i++) {
        a[i] = StdRandom.uniform(0.0, 1.0);
      }
      final Stopwatch timer = new Stopwatch();
      Insertion.sort(a);
      total += timer.elapsedTime();
    }
    return total;
  }

  public static void main(final String[] args) {
    Executor.execute(InsertionDoublingTest.class, args);

    final int trials = Integer.parseInt(args[0]);
    for (int n = 1024; true; n += n) {
      final double prev = timeTrials(trials, n / 2);
      final double curr = timeTrials(trials, n);
      final double ratio = curr / prev;
      StdOut.printf("%7d %4.2f%n", n, ratio);
    }
  }
}
