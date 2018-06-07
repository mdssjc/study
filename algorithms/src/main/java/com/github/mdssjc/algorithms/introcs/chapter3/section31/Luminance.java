package com.github.mdssjc.algorithms.introcs.chapter3.section31;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

import java.awt.*;

/**
 * Program 3.1.3 Luminance library.
 * <p>
 * Compilation:  javac Luminance.java
 * Execution:    java Luminance r1 g1 b1 r2 g2 b2
 * <p>
 * Library for dealing with monochrome luminance.
 * Uses the NTSC formula Y = 0.299*r + 0.587*g + 0.114*b.
 * <p>
 * % java Luminance 0 0 0 0 0 255
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"0", "0", "0", "0", "0", "255"})
public class Luminance {

  @Deprecated
  public static double lum(final Color color) {
    return intensity(color);
  }

  public static double intensity(final Color color) {
    final var r = color.getRed();
    final var g = color.getGreen();
    final var b = color.getBlue();
    return 0.299 * r + 0.587 * g + 0.114 * b;
  }

  public static Color toGray(final Color color) {
    final var y = (int) (Math.round(lum(color)));
    final var gray = new Color(y, y, y);
    return gray;
  }

  public static boolean areCompatible(final Color a, final Color b) {
    return Math.abs(intensity(a) - intensity(b)) >= 128.0;
  }

  public static void main(final String[] args) {
    Executor.execute(Luminance.class, args);

    final var a = new int[6];
    for (var i = 0; i < 6; i++) {
      a[i] = Integer.parseInt(args[i]);
    }
    final var c1 = new Color(a[0], a[1], a[2]);
    final var c2 = new Color(a[3], a[4], a[5]);
    StdOut.println("c1 = " + c1);
    StdOut.println("c2 = " + c2);
    StdOut.println("intensity(c1) =  " + intensity(c1));
    StdOut.println("intensity(c2) =  " + intensity(c2));
    StdOut.println(areCompatible(c1, c2));
  }
}
