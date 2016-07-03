package com.github.mdssjc.algorithms.assignments.loops;

public class RGBtoCMYK {

  private static double getBlack(final double white) {
    return 1 - white;
  }

  private static double getColor(final int color, final double white) {
    if (white == 0.0) {
      return 0.0;
    }
    return (white - color / 255.0) / white;
  }

  private static double getWhite(final int red, final int green,
      final int blue) {
    return Math.max(red / 255.0, Math.max(green / 255.0, blue / 255.0));
  }

  public static void main(final String[] args) {
    final int red = Integer.parseInt(args[0]);
    final int green = Integer.parseInt(args[1]);
    final int blue = Integer.parseInt(args[2]);

    final double white = getWhite(red, green, blue);
    final double cyan = getColor(red, white);
    final double magenta = getColor(green, white);
    final double yellow = getColor(blue, white);
    final double black = getBlack(white);

    System.out.println("cyan    = " + cyan);
    System.out.println("magenta = " + magenta);
    System.out.println("yellow  = " + yellow);
    System.out.println("black   = " + black);
  }
}
