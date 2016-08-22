package com.github.mdssjc.algorithms.assignments.hello;

import static java.lang.Math.acos;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

@TestDrive({ "40.35", "74.65", "48.87", "-2.33" })
@TestDrive({ "48.87", "-2.33", "40.35", "74.65" })
public class GreatCircle {

  public static void main(final String[] args) {
    Executor.execute(GreatCircle.class, args);

    // Latitude in degrees
    final double x1 = Double.parseDouble(args[0]); // Point 1
    final double y1 = Double.parseDouble(args[1]); // Point 2

    // Longitude in degrees
    final double x2 = Double.parseDouble(args[2]); // Point 1
    final double y2 = Double.parseDouble(args[3]); // Point 2

    final double acos = acos(
        sin(x1) * sin(x2) + cos(x1) * cos(x2) * cos(y1 - y2));
    final double distance = 60 * Math.toDegrees(acos);

    System.out.println(distance + " nautical miles");
  }

  private static double sin(final double x) {
    return Math.sin(Math.toRadians(x));
  }

  private static double cos(final double x) {
    return Math.cos(Math.toRadians(x));
  }
}
