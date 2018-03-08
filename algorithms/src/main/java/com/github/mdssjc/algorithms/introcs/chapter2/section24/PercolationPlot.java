package com.github.mdssjc.algorithms.introcs.chapter2.section24;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdDraw;

/**
 * Program 2.4.6 Adaptive plot client.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("20")
@TestDrive("100")
public class PercolationPlot {

  public static void curve(final int n, final double x0, final double y0, final double x1, final double y1) {
    final double gap = 0.01;
    final double err = 0.0025;
    final int trials = 10000;
    final double xm = (x0 + x1) / 2;
    final double ym = (y0 + y1) / 2;
    final double fxm = PercolationProbability.estimate(n, xm, trials);
    if (x1 - x0 < gap || Math.abs(ym - fxm) < err) {
      StdDraw.line(x0, y0, x1, y1);
      return;
    }
    curve(n, x0, y0, xm, fxm);
    StdDraw.filledCircle(xm, fxm, 0.005);
    curve(n, xm, fxm, x1, y1);
  }

  public static void main(final String[] args) {
    Executor.execute(PercolationPlot.class, args);

    final int n = Integer.parseInt(args[0]);
    curve(n, 0.0, 0.0, 1.0, 1.0);
  }
}
