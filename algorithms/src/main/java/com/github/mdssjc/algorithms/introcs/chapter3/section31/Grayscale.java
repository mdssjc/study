package com.github.mdssjc.algorithms.introcs.chapter3.section31;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.Picture;

import java.awt.*;

/**
 * Program 3.1.4 Converting color to grayscale.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = "mandrill.jpg", valueFile = true)
@TestDrive(value = "darwin.jpg", valueFile = true)
public class Grayscale {

  public static void main(final String[] args) {
    Executor.execute(Grayscale.class, args);

    final Picture picture = new Picture(args[0]);
    for (int col = 0; col < picture.width(); col++) {
      for (int row = 0; row < picture.height(); row++) {
        final Color color = picture.get(col, row);
        final Color gray = Luminance.toGray(color);
        picture.set(col, row, gray);
      }
    }
    picture.show();
  }
}
