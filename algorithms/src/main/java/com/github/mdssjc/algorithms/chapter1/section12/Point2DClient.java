package com.github.mdssjc.algorithms.chapter1.section12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * Point2D client.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"10", "10", "100"})
public class Point2DClient {

  public static void main(final String[] args) {
    Executor.execute(Point2DClient.class, args);

    final int x0 = Integer.parseInt(args[0]);
    final int y0 = Integer.parseInt(args[1]);
    final int n = Integer.parseInt(args[2]);

    StdDraw.setCanvasSize(800, 800);
    StdDraw.setXscale(0, 100);
    StdDraw.setYscale(0, 100);
    StdDraw.setPenRadius(0.005);
    StdDraw.enableDoubleBuffering();

    final Point2D[] points = new Point2D[n];
    for (int i = 0; i < n; i++) {
      final int x = StdRandom.uniform(100);
      final int y = StdRandom.uniform(100);
      points[i] = new Point2D(x, y);
      points[i].draw();
    }

    final Point2D p = new Point2D(x0, y0);
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.setPenRadius(0.02);
    p.draw();

    StdDraw.setPenRadius();
    StdDraw.setPenColor(StdDraw.BLUE);
    Arrays.sort(points, p.polarOrder());
    for (int i = 0; i < n; i++) {
      p.drawTo(points[i]);
      StdDraw.show();
      StdDraw.pause(100);
    }
  }
}
