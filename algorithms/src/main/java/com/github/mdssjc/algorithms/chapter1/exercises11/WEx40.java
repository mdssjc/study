package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Web Exercise 40.
 * <p>
 * Sattolo's algorithm.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( "10" )
public class WEx40 {

  public static void main(final String[] args) {
    Executor.execute(WEx40.class, args);

    final int n = Integer.parseInt(args[0]);

    final int[] items = new int[n];
    init(items);

    print(items);
    sattoloCycle(items);
    print(items);
  }

  private static void sattoloCycle(final int[] items) {
    int i = items.length;
    while (i > 1) {
      i--;
      final int j = StdRandom.uniform(i);
      final int swap = items[j];
      items[j] = items[i - 1];
      items[i - 1] = swap;
    }
  }

  private static void init(final int[] a) {
    for (int i = 0; i < a.length; i++) {
      a[i] = StdRandom.uniform(a.length);
    }
  }

  private static void print(final int[] items) {
    for (final int x : items) {
      StdOut.print(x + " ");
    }
    StdOut.println();
  }
}
