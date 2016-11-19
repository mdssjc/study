package com.github.mdssjc.algorithms.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Exercise 1.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( "6" )
public class Ex1 {

  public static void main(final String[] args) {
    Executor.execute(Ex1.class, args);

    final int n = Integer.parseInt(args[0]);

    final Point2D[] points = new Point2D[n];
    for (int i = 0; i < n; i++) {
      points[i] = new Point2D(StdRandom.random(), StdRandom.random());
    }

    double min = Double.MAX_VALUE;
    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        final double distance = points[i].distanceTo(points[j]);
        if (distance < min) {
          min = distance;
        }
      }
    }
    StdOut.println(min);
  }
}
