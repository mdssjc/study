package com.github.mdssjc.algorithms.chapter1.exercises14;

import com.github.mdssjc.algorithms.chapter1.section14.DoublingTest;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 3.
 * <p>
 * TODO: Seleção dos plots via linha de comando.
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

    for (int n = BEGIN, i = 0; n <= END; n += n, i++) {
      System.out.println(i);
      xs[i] = n;
      ys[i] = DoublingTest.timeTrial(n);
      //plot(xs, ys, i);
      plotLog(xs, ys, i);
      StdOut.printf("%7d %5.5f\n", n, ys[i]);
    }

    StdDraw.show();
  }

  // standard plot
  private static void plot(final int[] xs, final double[] ys, final int last) {
    if (last <= 2) {
      return;
    }
    StdDraw.clear();

    StdDraw.setXscale(xs[0], xs[last]);
    StdDraw.setYscale(ys[0], ys[last]);

    for (int i = 1; i <= last; i++) {
      final double x0 = xs[i - 1];
      final double y0 = ys[i - 1];
      final double x1 = xs[i];
      final double y1 = ys[i];

      StdDraw.line(x0, y0, x1, y1);
    }
  }

  // log-log plot
  private static void plotLog(final int[] xs, final double[] ys, final int last) {
    if (last <= 2) {
      return;
    }
    StdDraw.clear();

    double b = 0;
    if (ys.length >= 2) {
      b = lg(ys[last] / ys[last - 1]);
    }
    final double a = ys[last] / Math.pow(xs[last], b);
    final double c = lg(a);

    if (a > 0) {
      StdDraw.setXscale(lg(xs[0]), lg(xs[last]));
      StdDraw.setYscale(b * lg(xs[0]) + c, b * lg(xs[last]) + c);
    }

    for (int i = 1; i <= last; i++) {
      final double x0 = lg(xs[i - 1]);
      final double y0 = b * lg(xs[i - 1]) + c;
      // final double y0 = lg(ys[i-1]);
      final double x1 = lg(xs[i]);
      final double y1 = b * lg(xs[i]) + c;
      // final double y1 = lg(ys[i]);

      StdDraw.line(x0, y0, x1, y1);
    }
  }

  private static double lg(final double x) {
    return Math.log10(x) / Math.log10(2);
  }
}
