package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

/**
 * Creative Exercise 31.
 * <p>
 * Random connections.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( {"5", "0.2"} )
public class CEx31 {

  private static final double CENTER = 0.5;
  private static final double RADIUS = 0.4;
  private static final double DOT_RADIUS = 0.05;

  public static void main(final String[] args) {
    Executor.execute(CEx31.class, args);

    final int n = Integer.parseInt(args[0]);
    final double p = Double.parseDouble(args[1]);

    StdDraw.circle(CENTER, CENTER, RADIUS);

    double xOld = -1;
    double yOld = -1;

    for (int i = 0; i < n; ) {
      final double x = StdRandom.random();
      final double y = StdRandom.random();

      final double dx = (CENTER - x + (x > CENTER ? -DOT_RADIUS : DOT_RADIUS));
      final double dy = (CENTER - y + (y > CENTER ? -DOT_RADIUS : DOT_RADIUS));
      final double distanceSquare = dx * dx + dy * dy;
      final double radiusSquare = RADIUS * RADIUS;

      if (distanceSquare <= radiusSquare) {
        StdDraw.filledCircle(x, y, DOT_RADIUS);
        i++;

        if (xOld > 0 && yOld > 0 && StdRandom.bernoulli(p)) {
          StdDraw.setPenColor(Color.GRAY);
          StdDraw.line(xOld, yOld, x, y);
          StdDraw.setPenColor(Color.BLACK);
        }

        xOld = x;
        yOld = y;
      }
    }

    try {
      Thread.sleep(5000);
    } catch (final InterruptedException exception) {
      StdOut.println(exception.getMessage());
    }
  }
}
