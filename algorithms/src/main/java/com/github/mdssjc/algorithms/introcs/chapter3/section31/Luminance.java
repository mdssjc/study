package com.github.mdssjc.algorithms.introcs.chapter3.section31;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

import java.awt.*;

/**
 * Program 3.1.3 Luminance library.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"232", "232", "232", "0", "0", "0"})
@TestDrive({"9", "90", "166", "232", "232", "232"})
@TestDrive({"9", "90", "166", "0", "0", "0"})
public class Luminance {

  public static double intensity(final Color color) {
    final int r = color.getRed();
    final int g = color.getGreen();
    final int b = color.getBlue();
    return 0.299 * r + 0.587 * g + 0.114 * b;
  }

  public static Color toGray(final Color color) {
    final int y = (int) Math.round(intensity(color));
    final Color gray = new Color(y, y, y);
    return gray;
  }

  public static boolean areCompatible(final Color a, final Color b) {
    return Math.abs(intensity(a) - intensity(b)) >= 128.0;
  }

  public static void main(final String[] args) {
    Executor.execute(Luminance.class, args);

    final int[] a = new int[6];
    for (int i = 0; i < 6; i++) {
      a[i] = Integer.parseInt(args[i]);
    }
    final Color c1 = new Color(a[0], a[1], a[2]);
    final Color c2 = new Color(a[3], a[4], a[5]);
    StdOut.println(areCompatible(c1, c2));
  }
}
