package com.github.mdssjc.algorithms.introcs.chapter2.section23;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdRandom;

/**
 * Program 2.3.5 Brownian bridge.
 * <p>
 * Compilation:  javac Brownian.java
 * Execution:    java Brownian var
 * Dependencies: StdDraw.java
 * <p>
 * Plots Brownian motion trajectory using the midpoint displacement
 * method.
 * <p>
 * % java Brownian 1
 * <p>
 * % java Brownian 0.5
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("1")
@TestDrive("0.5")
public class Brownian {

  public static void curve(final double x0, final double y0, final double x1, final double y1, final double var, final double s) {
    if (Math.abs(x1 - x0) < 0.01) {
      StdDraw.line(x0, y0, x1, y1);
      return;
    }

    final var xm = (x0 + x1) / 2;
    var ym = (y0 + y1) / 2;
    ym += StdRandom.gaussian(0, Math.sqrt(var));
    curve(x0, y0, xm, ym, var / s, s);
    curve(xm, ym, x1, y1, var / s, s);
  }

  public static void main(final String[] args) {
    Executor.execute(Brownian.class, args);

    final var hurstExponent = Double.parseDouble(args[0]);
    final var s = Math.pow(2, 2 * hurstExponent);
    curve(0.0, 0.5, 1.0, 0.5, 0.01, s);
  }
}
