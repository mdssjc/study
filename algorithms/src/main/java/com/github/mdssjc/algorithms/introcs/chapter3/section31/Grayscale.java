package com.github.mdssjc.algorithms.introcs.chapter3.section31;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.Picture;

/**
 * Program 3.1.4 Converting color to grayscale.
 * <p>
 * Compilation:  javac Grayscale.java
 * Execution:    java Grayscale filename
 * Data files:   http://www.cs.princeton.edu/introcs/31datatype/mandrill.jpg
 *               http://www.cs.princeton.edu/introcs/31datatype/darwin.jpg
 * <p>
 * Reads in an image from a file, converts it to grayscale, and
 * displays it on the screen.
 * <p>
 * % java Grayscale image.jpg
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = "mandrill.jpg", valueFile = true)
@TestDrive(value = "darwin.jpg", valueFile = true)
public class Grayscale {

  public static void main(final String[] args) {
    Executor.execute(Grayscale.class, args);

    final var picture = new Picture(args[0]);
    final var width = picture.width();
    final var height = picture.height();

    for (var col = 0; col < width; col++) {
      for (var row = 0; row < height; row++) {
        final var color = picture.get(col, row);
        final var gray = Luminance.toGray(color);
        picture.set(col, row, gray);
      }
    }
    picture.show();
  }
}
