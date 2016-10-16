package com.github.mdssjc.algorithms.chapter1.section14;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * DoublingTest Class.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class DoublingTest {

  public static double timeTrial(final int n) {
    // Time ThreeSum.count() for N random 6-digit ints.
    final int MAX = 1000000;
    final int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = StdRandom.uniform(-MAX, MAX);
    }
    final Stopwatch timer = new Stopwatch();
    final int cnt = ThreeSum.count(a);
    return timer.elapsedTime();
  }

  public static void main(final String[] args) {
    Executor.execute(DoublingTest.class, args);

    // Print table of running times.
    for (int n = 250; true; n += n) {
      // Print time for problem size N.
      final double time = timeTrial(n);
      StdOut.printf("%7d %5.1f\n", n, time);
    }
  }
}
