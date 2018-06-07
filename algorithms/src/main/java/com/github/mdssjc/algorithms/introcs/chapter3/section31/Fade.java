package com.github.mdssjc.algorithms.introcs.chapter3.section31;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.Picture;

import java.awt.*;

/**
 * Program 3.1.6 Fade effect.
 * <p>
 * Compilation:  javac Fade.java
 * Execution:    java Fade n image1.jpg image2.jpg
 * Data files:   https://introcs.cs.princeton.edu/31datatype/darwin.jpg
 *               https://introcs.cs.princeton.edu/31datatype/mandrill.jpg
 * <p>
 * Produce animated effect, fading from image1.jpg to image2.jpg,
 * using n-1 intermediate frames.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = {"9", "mandrill.jpg", "darwin.jpg"}, valueFile = true)
public class Fade {

  public static Color combine(final Color c1, final Color c2, final double alpha) {
    final var r = (int) (alpha * c1.getRed() + (1 - alpha) * c2.getRed());
    final var g = (int) (alpha * c1.getGreen() + (1 - alpha) * c2.getGreen());
    final var b = (int) (alpha * c1.getBlue() + (1 - alpha) * c2.getBlue());
    return new Color(r, g, b);
  }

  public static void main(final String[] args) {
    Executor.execute(Fade.class, args);

    final var n = Integer.parseInt(args[0]);
    final var picture1 = new Picture(args[1]);
    final var picture2 = new Picture(args[2]);
    final var width = picture1.width();
    final var height = picture1.height();
    final var picture = new Picture(width, height);
    for (var k = 0; k <= n; k++) {
      final var alpha = 1.0 * k / n;
      for (var col = 0; col < width; col++) {
        for (var row = 0; row < height; row++) {
          final var c1 = picture1.get(col, row);
          final var c2 = picture2.get(col, row);
          picture.set(col, row, combine(c2, c1, alpha));
        }
      }
      picture.show();
    }
  }
}
