package com.github.mdssjc.algorithms.assignments.hello;

import static java.lang.Math.acos;

public class GreatCircle {

  public static void main(String[] args) {
    // Latitude in degrees
    double x1 = Double.parseDouble(args[0]); // Point 1
    double y1 = Double.parseDouble(args[1]); // Point 2

    // Longitude in degrees
    double x2 = Double.parseDouble(args[2]); // Point 1
    double y2 = Double.parseDouble(args[3]); // Point 2

    double acos = acos(sin(x1) * sin(x2) + cos(x1) * cos(x2) * cos(y1 - y2));
    double distance = 60 * Math.toDegrees(acos);

    System.out.println(distance + " nautical miles");
  }

  private static double sin(double x) {
    return Math.sin(Math.toRadians(x));
  }

  private static double cos(double x) {
    return Math.cos(Math.toRadians(x));
  }
}
