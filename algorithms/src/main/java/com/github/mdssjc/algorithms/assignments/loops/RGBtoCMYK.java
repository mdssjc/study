package com.github.mdssjc.algorithms.assignments.loops;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Assignment RGBtoCMYK.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( {"75", "0", "130"} )
@TestDrive( {"255", "143", "0"} )
@TestDrive( {"0", "0", "0"} )
public class RGBtoCMYK {

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

    StdOut.println("red     = " + red);
    StdOut.println("green   = " + green);
    StdOut.println("blue    = " + blue);
    StdOut.println("cyan    = " + cyan);
    StdOut.println("magenta = " + magenta);
    StdOut.println("yellow  = " + yellow);
    StdOut.println("black   = " + black);
  }

  private static double getBlack(final double white) {
    return 1 - white;
  }

  private static double getColor(final int color, final double white) {
    final double cmy = (white - color / 255.0) / white;
    return (Double.isNaN(cmy) ? 0 : cmy);
  }

  private static double getWhite(final int red, final int green, final int blue) {
    return Math.max(red / 255.0, Math.max(green / 255.0, blue / 255.0));
  }
}
