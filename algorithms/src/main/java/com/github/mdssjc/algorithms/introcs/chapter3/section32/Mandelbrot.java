package com.github.mdssjc.algorithms.introcs.chapter3.section32;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.Picture;

import java.awt.*;

/**
 * Program 3.2.7 Mandelbrot set.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"-0.5", "0", "2"})
@TestDrive({"0.1015", "-0.633", "0.01"})
public class Mandelbrot {

  private static int mand(final Complex z0, final int max) {
    Complex z = z0;
    for (int t = 0; t < max; t++) {
      if (z.abs() > 2.0) {
        return t;
      }
      z = z.times(z)
           .plus(z0);
    }
    return max;
  }

  public static void main(final String[] args) {
    Executor.execute(Mandelbrot.class, args);

    final double xc = Double.parseDouble(args[0]);
    final double yc = Double.parseDouble(args[1]);
    final double size = Double.parseDouble(args[2]);
    final int n = 512;
    final Picture picture = new Picture(n, n);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        final double x0 = xc - size / 2 + size * i / n;
        final double y0 = yc - size / 2 + size * j / n;
        final Complex z0 = new Complex(x0, y0);
        final int gray = 255 - mand(z0, 255);
        final Color c = new Color(gray, gray, gray);
        picture.set(i, n - 1 - j, c);
      }
    }
    picture.show();
  }
}
