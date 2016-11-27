package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdDraw;

/**
 * Web Exercise 43.
 * <p>
 * Bouncing ball.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class WEx43 {

  public static void main(final String[] args) {
    Executor.execute(WEx43.class, args);

    // set the scale of the coordinate system
    StdDraw.setXscale(-1.0, 1.0);
    StdDraw.setYscale(-1.0, 1.0);
    StdDraw.enableDoubleBuffering();

    // initial values
    double rx = 0.480; // position
    double ry = 0.860;
    double vx = 0.015; // velocity
    double vy = 0.023;
    final double radius = 0.05; // radius

    // main animation loop
    while (true) {

      // bounce off wall according to law of elastic collision
      if (Math.abs(rx + vx) > 1.0 - radius) vx = -vx;
      if (Math.abs(ry + vy) > 1.0 - radius) vy = -vy;

      // update position
      rx = rx + vx;
      ry = ry + vy;

      // clear the background
      StdDraw.setPenColor(StdDraw.GRAY);
      StdDraw.filledSquare(0, 0, 1.0);

      // draw ball on the screen
      StdDraw.setPenColor(StdDraw.BLACK);
      StdDraw.filledCircle(rx, ry, radius);

      // display and pause for 20 ms
      StdDraw.show();
      StdDraw.pause(20);
    }
  }
}
