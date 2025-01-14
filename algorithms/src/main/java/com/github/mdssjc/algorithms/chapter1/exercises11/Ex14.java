package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 1.1.14.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex14 {

  public static void main(final String[] args) {
    Executor.execute(Ex14.class, args);

    for (int i = 0; i < 1000; i += 2) {
      final int lg = lg(i);
      final double log = Math.log(i) / Math.log(2);

      StdOut.printf("%d %d %.2f%n", i, lg, log);

      if (lg > log && Double.isFinite(log)) {
        throw new RuntimeException();
      }
    }
  }

  private static int lg(final int n) {
    int count = 0;
    int r = 2;

    while (r <= n) {
      count++;
      r *= 2;
    }
    return count;
  }
}
