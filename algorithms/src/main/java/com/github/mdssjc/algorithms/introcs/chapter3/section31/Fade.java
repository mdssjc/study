package com.github.mdssjc.algorithms.introcs.chapter3.section31;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.Picture;

import java.awt.*;

/**
 * Program 3.1.6 Fade effect.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = {"mandrill.jpg", "darwin.jpg", "9"}, valueFile = true)
public class Fade {

  public static Color blend(final Color c1, final Color c2, final double alpha) {
    final double r = (1 - alpha) * c1.getRed() + alpha * c2.getRed();
    final double g = (1 - alpha) * c1.getGreen() + alpha * c2.getGreen();
    final double b = (1 - alpha) * c1.getBlue() + alpha * c2.getBlue();
    return new Color((int) r, (int) g, (int) b);
  }

  public static void main(final String[] args) {
    Executor.execute(Fade.class, args);

    final Picture source = new Picture(args[0]);
    final Picture target = new Picture(args[1]);
    final int n = Integer.parseInt(args[2]);
    final int width = source.width();
    final int height = source.height();
    final Picture picture = new Picture(width, height);
    for (int i = 0; i <= n; i++) {
      for (int col = 0; col < width; col++) {
        for (int row = 0; row < height; row++) {
          final Color c1 = source.get(col, row);
          final Color c2 = target.get(col, row);
          final double alpha = (double) i / n;
          final Color color = blend(c1, c2, alpha);
          picture.set(col, row, color);
        }
      }
      picture.show();
    }
  }
}
