package com.github.mdssjc.algorithms.introcs.assignments.hello;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

import static java.lang.Math.acos;

/**
 * Assignment 0: Floating-point numbers and the Math library.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"40.35", "74.65", "48.87", "-2.33"}) // Princeton to Paris
@TestDrive({"48.87", "-2.33", "40.35", "74.65"}) // Paris to Princeton
public class GreatCircle {

  public static void main(final String[] args) {
    Executor.execute(GreatCircle.class, args);

    // Latitude in degrees
    final double x1 = Double.parseDouble(args[0]); // Point 1
    final double y1 = Double.parseDouble(args[1]); // Point 2

    // Longitude in degrees
    final double x2 = Double.parseDouble(args[2]); // Point 1
    final double y2 = Double.parseDouble(args[3]); // Point 2

    final double acos = acos(sin(x1) * sin(x2) +
                             cos(x1) * cos(x2) * cos(y1 - y2));
    final double distance = 60 * Math.toDegrees(acos);

    StdOut.println(distance + " nautical miles");
  }

  private static double sin(final double x) {
    return Math.sin(Math.toRadians(x));
  }

  private static double cos(final double x) {
    return Math.cos(Math.toRadians(x));
  }
}
