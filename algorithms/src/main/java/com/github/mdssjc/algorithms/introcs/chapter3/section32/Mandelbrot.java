package com.github.mdssjc.algorithms.introcs.chapter3.section32;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.Picture;

import java.awt.*;

/**
 * Program 3.2.7 Mandelbrot set.
 * <p>
 * Compilation:  javac Mandelbrot.java
 * Execution:    java Mandelbrot xc yc size
 * Dependencies: StdDraw.java
 * <p>
 * Plots the size-by-size region of the Mandelbrot set, centered on (xc, yc)
 * <p>
 * % java Mandelbrot -0.5 0 2
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"-0.5", "0", "2"})
public class Mandelbrot {

  public static int mand(final Complex z0, final int max) {
    var z = z0;
    for (var t = 0; t < max; t++) {
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

    final var xc = Double.parseDouble(args[0]);
    final var yc = Double.parseDouble(args[1]);
    final var size = Double.parseDouble(args[2]);

    final var n = 512;
    final var max = 255;

    final var picture = new Picture(n, n);
    for (var i = 0; i < n; i++) {
      for (var j = 0; j < n; j++) {
        final var x0 = xc - size / 2 + size * i / n;
        final var y0 = yc - size / 2 + size * j / n;
        final var z0 = new Complex(x0, y0);
        final var gray = max - mand(z0, max);
        final var color = new Color(gray, gray, gray);
        picture.set(i, n - 1 - j, color);
      }
    }
    picture.show();
  }
}
