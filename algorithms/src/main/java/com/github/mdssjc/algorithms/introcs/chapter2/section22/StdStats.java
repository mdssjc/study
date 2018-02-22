package com.github.mdssjc.algorithms.introcs.chapter2.section22;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 2.2.4 Data analysis library.
 * Program 2.2.5 Plotting data values in an array.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "tiny1D.txt", inputFile = true)
public class StdStats {

  public static double min(final double[] a) {
    double min = Double.POSITIVE_INFINITY;
    for (int i = 0; i < a.length; i++) {
      if (a[i] < min) {
        min = a[i];
      }
    }
    return min;
  }

  public static double max(final double[] a) {
    double max = Double.NEGATIVE_INFINITY;
    for (int i = 0; i < a.length; i++) {
      if (a[i] > max) {
        max = a[i];
      }
    }
    return max;
  }

  public static double mean(final double[] a) {
    double sum = 0.0;
    for (int i = 0; i < a.length; i++) {
      sum = sum + a[i];
    }
    return sum / a.length;
  }

  public static double var(final double[] a) {
    final double avg = mean(a);
    double sum = 0.0;
    for (int i = 0; i < a.length; i++) {
      sum += (a[i] - avg) * (a[i] - avg);
    }
    return sum / (a.length - 1);
  }

  public static double stddev(final double[] a) {
    return Math.sqrt(var(a));
  }

  public static void plotPoints(final double[] a) {
    final int n = a.length;
    StdDraw.setXscale(-1, n);
    StdDraw.setPenRadius(1 / (3.0 * n));
    for (int i = 0; i < n; i++) {
      StdDraw.point(i, a[i]);
    }
  }

  public static void plotLines(final double[] a) {
    final int n = a.length;
    StdDraw.setXscale(-1, n);
    StdDraw.setPenRadius();
    for (int i = 1; i < n; i++) {
      StdDraw.line(i - 1, a[i - 1], i, a[i]);
    }
  }

  public static void plotBars(final double[] a) {
    final int n = a.length;
    StdDraw.setXscale(-1, n);
    for (int i = 0; i < n; i++) {
      StdDraw.filledRectangle(i, a[i] / 2, 0.25, a[i] / 2);
    }
  }

  public static void main(final String[] args) {
    Executor.execute(StdStats.class, args);

    double[] a = StdArrayIO.readDouble1D();
    StdOut.printf("     min %7.3f%n", min(a));
    StdOut.printf("    mean %7.3f%n", mean(a));
    StdOut.printf("     max %7.3f%n", max(a));
    StdOut.printf(" std dev %7.3f%n", stddev(a));

    final int n = 20;
    a = new double[n];
    for (int i = 0; i < n; i++) {
      a[i] = 1.0 / (i + 1);
      plotPoints(a);
      plotLines(a);
      plotBars(a);
    }
  }
}
