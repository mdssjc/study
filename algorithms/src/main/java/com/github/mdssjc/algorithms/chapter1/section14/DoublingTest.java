package com.github.mdssjc.algorithms.chapter1.section14;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Doubling test.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class DoublingTest {

  private static final int MAX = 1000000;

  public static void main(final String[] args) {
    Executor.execute(DoublingTest.class, args);

    for (int n = 250; true; n += n) {
      final double time = timeTrial(n);
      StdOut.printf("%7d %7.1f%n", n, time);
    }
  }

  public static double timeTrial(final int n) {
    final int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = StdRandom.uniform(-MAX, MAX);
    }
    final Stopwatch timer = new Stopwatch();
    ThreeSum.count(a);
    return timer.elapsedTime();
  }
}
