package com.github.mdssjc.algorithms.introcs.chapter3.section32;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 3.2.2 Stopwatch.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("100000000")
public class Stopwatch {

  private final long start;

  public Stopwatch() {
    this.start = System.currentTimeMillis();
  }

  public double elapsedTime() {
    final long now = System.currentTimeMillis();
    return (now - this.start) / 1000.0;
  }

  public static void main(final String[] args) {
    Executor.execute(Stopwatch.class, args);

    final int n = Integer.parseInt(args[0]);
    final Stopwatch timer1 = new Stopwatch();
    double sum1 = 0.0;
    for (int i = 1; i <= n; i++) {
      sum1 += Math.sqrt(i);
    }
    final double time1 = timer1.elapsedTime();
    StdOut.printf("%e (%.2f seconds)\n", sum1, time1);

    final Stopwatch timer2 = new Stopwatch();
    double sum2 = 0.0;
    for (int i = 1; i <= n; i++) {
      sum2 += Math.pow(i, 0.5);
    }
    final double time2 = timer2.elapsedTime();
    StdOut.printf("%e (%.2f seconds)\n", sum2, time2);
  }
}
