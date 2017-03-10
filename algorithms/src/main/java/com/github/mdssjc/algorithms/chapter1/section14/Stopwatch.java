package com.github.mdssjc.algorithms.chapter1.section14;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Timer (wall time).
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("1000")
@TestDrive("2000")
public class Stopwatch {

  private final long start;

  public Stopwatch() {
    this.start = System.currentTimeMillis();
  }

  public static void main(final String[] args) {
    Executor.execute(Stopwatch.class, args);

    final int n = Integer.parseInt(args[0]);

    final int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = StdRandom.uniform(-1000000, 1000000);
    }

    final Stopwatch timer = new Stopwatch();
    final int count = ThreeSum.count(a);
    final double time = timer.elapsedTime();

    StdOut.println(count + " triples " + time + " seconds");
  }

  public double elapsedTime() {
    final long now = System.currentTimeMillis();
    return (now - this.start) / 1000.0;
  }
}
