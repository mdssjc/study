package com.github.mdssjc.algorithms.assignments.hello;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

@TestDrive({ "75", "0", "130" })
@TestDrive({ "255", "143", "0" })
public class RGBtoCMYK {

  private static double getBlack(final double white) {
    return 1 - white;
  }

  private static double getColor(final int color, final double white) {
    return (white - color / 255.0) / white;
  }

  private static double getWhite(final int red, final int green,
      final int blue) {
    return Math.max(red / 255.0, Math.max(green / 255.0, blue / 255.0));
  }

  public static void main(final String[] args) {
    Executor.execute(RGBtoCMYK.class, args);

    final int red = Integer.parseInt(args[0]);
    final int green = Integer.parseInt(args[1]);
    final int blue = Integer.parseInt(args[2]);

    final double white = getWhite(red, green, blue);
    final double cyan = getColor(red, white);
    final double magenta = getColor(green, white);
    final double yellow = getColor(blue, white);
    final double black = getBlack(white);

    System.out.println("red     = " + red);
    System.out.println("green   = " + green);
    System.out.println("blue    = " + blue);
    System.out.println("cyan    = " + cyan);
    System.out.println("magenta = " + magenta);
    System.out.println("yellow  = " + yellow);
    System.out.println("black   = " + black);
  }
}
