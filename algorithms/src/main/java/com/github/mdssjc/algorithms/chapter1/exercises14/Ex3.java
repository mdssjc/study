package com.github.mdssjc.algorithms.chapter1.exercises14;

import com.github.mdssjc.algorithms.chapter1.section14.DoublingTest;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 3.
 *
 * TODO: corrigir e seleção entre plots.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex3 {

  private static final int END = 25000;
  private static final int BEGIN = 250;

  public static void main(final String[] args) {
    Executor.execute(Ex3.class, args);

    final int len = END / BEGIN;
    final int[] xs = new int[len];
    final double[] ys = new double[len];

    xs[0] = 0;
    ys[0] = 0.0;

    for (int n = BEGIN, i = 1; n <= END; n += n, i++) {
      xs[i] = n;
      ys[i] = DoublingTest.timeTrial(n);
      plot(xs, ys, i);
      StdOut.printf("%7d %5.1f\n", n, ys[i]);
    }

    StdDraw.show();
  }

  private static void plot(final int[] xs, final double[] ys, final int last) {
    StdDraw.clear();

    StdDraw.setXscale(0, xs[last]);
    StdDraw.setYscale(0, ys[last]);

    for (int i = 1; i <= last; i++) {
      // standard plot
      final double x0 = xs[i - 1];
      double y0 = ys[i - 1];
      final double x1 = xs[i];
      double y1 = ys[i];

      // log-log plot
      y0 = Math.log(x0) / Math.log(y0);
      y1 = Math.log(x1) / Math.log(y1);

      StdDraw.line(x0, y0, x1, y1);
    }
  }
}
