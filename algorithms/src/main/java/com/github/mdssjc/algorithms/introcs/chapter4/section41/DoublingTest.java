package com.github.mdssjc.algorithms.introcs.chapter4.section41;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.Stopwatch;

/**
 * Program 4.1.2 Validating a doubling hypothesis.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class DoublingTest {

  public static double timeTrial(final int n) {
    final int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = StdRandom.uniform(2000000) - 1000000;
    }
    final Stopwatch timer = new Stopwatch();
    final int count = ThreeSum.countTriples(a);
    return timer.elapsedTime();
  }

  public static void main(final String[] args) {
    Executor.execute(DoublingTest.class, args);

    for (int n = 512; true; n *= 2) {
      final double previous = timeTrial(n / 2);
      final double current = timeTrial(n);
      final double ratio = current / previous;
      StdOut.printf("%7d %4.2f\n", n, ratio);
    }
  }
}
