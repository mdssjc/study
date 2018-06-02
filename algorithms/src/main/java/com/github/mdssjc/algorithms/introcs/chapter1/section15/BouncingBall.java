package com.github.mdssjc.algorithms.introcs.chapter1.section15;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdDraw;

/**
 * Program 1.5.6 Bouncing ball.
 * <p>
 * Compilation:  javac BouncingBall.java
 * Execution:    java BouncingBall
 * Dependencies: StdDraw.java
 * <p>
 * Implementation of a 2-d bouncing ball in the box from (-1, -1) to (1, 1).
 * <p>
 * % java BouncingBall
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

    var rx = 0.480;
    var ry = 0.860;
    var vx = 0.015;
    var vy = 0.023;
    final var radius = 0.05;

    while (true) {
      if (Math.abs(rx + vx) > 1.0 - radius) {
        vx = -vx;
      }
      if (Math.abs(ry + vy) > 1.0 - radius) {
        vy = -vy;
      }

      rx += vx;
      ry += vy;

      StdDraw.clear(StdDraw.LIGHT_GRAY);

      StdDraw.setPenColor(StdDraw.BLACK);
      StdDraw.filledCircle(rx, ry, radius);

      StdDraw.show();

      StdDraw.pause(20);
    }
  }
}
