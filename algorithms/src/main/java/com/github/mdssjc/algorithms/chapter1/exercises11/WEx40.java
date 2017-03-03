package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * Web Exercise 40.
 * <p>
 * Sattolo's algorithm.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("10")
public class WEx40 {

  public static void main(final String[] args) {
    Executor.execute(WEx40.class, args);

    final int n = Integer.parseInt(args[0]);

    final int[] items = new int[n];
    init(items);

    StdOut.println(Arrays.toString(items));
    sattoloCycle(items);
    StdOut.println(Arrays.toString(items));
  }

  private static void sattoloCycle(final int[] a) {
    for (int i = a.length; i > 1; i--) {
      final int r = StdRandom.uniform(i);
      final int swap = a[r];
      a[r] = a[i - 1];
      a[i - 1] = swap;
    }
  }

  private static void init(final int[] a) {
    for (int i = 0; i < a.length; i++) {
      a[i] = StdRandom.uniform(a.length);
    }
  }
}
