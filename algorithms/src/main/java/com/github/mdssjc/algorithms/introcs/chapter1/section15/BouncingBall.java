package com.github.mdssjc.algorithms.introcs.chapter1.section15;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdDraw;

/**
 * Program 1.5.6 Bouncing ball.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class BouncingBall {

  public static void main(final String[] args) {
    Executor.execute(BouncingBall.class, args);

    StdDraw.setXscale(-1.0, 1.0);
    StdDraw.setYscale(-1.0, 1.0);
    StdDraw.enableDoubleBuffering();

    double rx = 0.480, ry = 0.860;
    double vx = 0.015, vy = 0.023;
    final double radius = 0.05;

    while (true) {
      if (Math.abs(rx + vx) + radius > 1.0) {
        vx = -vx;
      }
      if (Math.abs(ry + vy) + radius > 1.0) {
        vy = -vy;
      }
      rx += vx;
      ry += vy;
      StdDraw.clear();
      StdDraw.filledCircle(rx, ry, radius);
      StdDraw.show();
      StdDraw.pause(20);
    }
  }
}
