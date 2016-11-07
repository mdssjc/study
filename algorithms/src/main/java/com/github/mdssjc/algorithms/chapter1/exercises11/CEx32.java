package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Creative Exercise 32.
 * <p>
 * Histogram.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( value = {"10", "0.2", "3.0"}, input = "0.2 0.2 0.2 0.7 1.2 1.3 1.4 2.5 3.0" )
public class CEx32 {

  public static void main(final String[] args) {
    Executor.execute(CEx32.class, args);

    final int n = Integer.parseInt(args[0]);
    final double left = Double.parseDouble(args[1]);
    final double right = Double.parseDouble(args[2]);

    final int[] count = new int[n];
    final double k = (right - left) / (n - 1);
    double total = 0;
    while (!StdIn.isEmpty()) {
      final double current = StdIn.readDouble();
      final int v = (int) (current / k);
      count[v]++;
      total++;
    }

    for (int i = 0; i < n; i++) {
      final double x = (1.0 * i / n) + (1.0 / n / 2);
      final double y = count[i] / total;
      final double rw = 0.5 / n;
      final double rh = count[i] / total;
      StdDraw.filledRectangle(x, y, rw, rh);
    }

    try {
      Thread.sleep(5000);
    } catch (final InterruptedException exception) {
      StdOut.println(exception);
    }
  }
}

