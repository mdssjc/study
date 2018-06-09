package com.github.mdssjc.algorithms.introcs.chapter4.section41;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.Stopwatch;

/**
 * Program 4.1.2 Validating a doubling hypothesis.
 * <p>
 * Compilation:  javac DoublingTest.java
 * Execution:    java DoublingTest
 * <p>
 * % java DoublingTest
 *     512 6.48
 *    1024 8.30
 *    2048 7.75
 *    4096 8.00
 *    8192 8.05
 *  ...
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class DoublingTest {

  public static double timeTrial(final int n) {
    final var a = new int[n];
    for (var i = 0; i < n; i++) {
      a[i] = StdRandom.uniform(2000000) - 1000000;
    }
    final var s = new Stopwatch();
    ThreeSum.count(a);
    return s.elapsedTime();
  }

  public static void main(final String[] args) {
    Executor.execute(DoublingTest.class, args);

    StdOut.printf("%7s %7s %4s%n", "size", "time", "ratio");
    var previous = timeTrial(256);
    for (var n = 512; true; n += n) {
      final var current = timeTrial(n);
      StdOut.printf("%7d %7.2f %4.2f%n", n, current, current / previous);
      previous = current;
    }
  }
}
