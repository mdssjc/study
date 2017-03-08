package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Creative Exercise 31.
 * <p>
 * Random connections.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"12", "0.25"})
public class CEx31 {

  private static final double CENTER = 0.5;
  private static final double RADIUS = 0.4;
  private static final double DOT_RADIUS = 0.05;

  public static void main(final String[] args) {
    Executor.execute(CEx31.class, args);

    final int n = Integer.parseInt(args[0]);
    final double p = Double.parseDouble(args[1]);

    final Point2D[] points = new Point2D[n];
    final double distance = 360.0 / n * Math.PI / 180;

    for (int i = 0; i < n; i++) {
      final double arc = i * distance;
      final double dx = RADIUS * Math.cos(arc);
      final double dy = RADIUS * Math.sin(arc);

      points[i] = new Point2D(CENTER + dx, CENTER + dy);
    }

    StdDraw.circle(CENTER, CENTER, RADIUS);

    for (int i = 0; i < points.length; i++) {
      StdDraw.setPenRadius(DOT_RADIUS);
      points[i].draw();
      StdDraw.setPenRadius();

      int k = i + 1;
      while (true) {
        if (k > points.length - 1) {
          break;
        }
        if (StdRandom.bernoulli(p)) {
          StdDraw.line(points[i].x(), points[i].y(), points[k].x(), points[k].y());
        }
        k++;
      }
    }
  }
}
