package com.github.mdssjc.algorithms.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Exercício 3.
 * 
 * @author Marcelo dos Santos
 *
 */
@TestDrive({ "5", "5", "50" })
public class Ex3 {

  public static void main(final String[] args) {
    Executor.execute(Ex3.class, args);

    final int N = Integer.parseInt(args[0]);
    final int min = Integer.parseInt(args[1]);
    final int max = Integer.parseInt(args[2]);

    final Interval2D[] intervals = new Interval2D[N];
    for (int i = 0; i < intervals.length; i++) {
      final Interval1D width = makeInterval1D(min, max);
      final Interval1D height = makeInterval1D(min, max);
      intervals[i] = new Interval2D(width, height);
    }

    final int[] intersects = new int[N];
    for (int i = 0; i < intervals.length; i++) {
      for (int j = 0; j < intervals.length; j++) {
        if (i != j && intervals[i].intersects(intervals[j])) {
          intersects[i]++;
          StdOut.println(intersects[i] + " - " + intersects[j]);
        }
      }
      intervals[i].draw();
      StdOut.println(intersects[i] + " pairs");
    }

    try {
      Thread.sleep(5000);
    } catch (final InterruptedException e) {
      e.printStackTrace();
    }
  }

  private static Interval1D makeInterval1D(final int min, final int max) {
    final double a = scale(StdRandom.uniform(min, max), min, max);
    final double b = scale(StdRandom.uniform(min, max), min, max);
    return new Interval1D(Math.min(a, b), Math.max(a, b));
  }

  public static double scale(final double x, final int min, final int max) {
    return (x - min) / (max - min);
  }
}
