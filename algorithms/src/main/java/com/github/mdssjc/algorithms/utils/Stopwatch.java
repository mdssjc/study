package com.github.mdssjc.algorithms.utils;

import com.github.mdssjc.algorithms.chapter1.section14.ThreeSum;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Stopwatch Class.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("1000")
@TestDrive("2000")
public class Stopwatch {

  private final long start;

  public Stopwatch() {
    start = System.currentTimeMillis();
  }

  public double elapsedTime() {
    final long now = System.currentTimeMillis();
    return (now - start) / 1000.0;
  }

  public static void main(final String[] args) {
    Executor.execute(Stopwatch.class, args);

    final int n = Integer.parseInt(args[0]);

    final int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = StdRandom.uniform(-1000000, 1000000);
    }

    final Stopwatch timer = new Stopwatch();
    final int cnt = ThreeSum.count(a);
    final double time = timer.elapsedTime();

    StdOut.println(cnt + " triples " + time + " seconds");
  }
}
