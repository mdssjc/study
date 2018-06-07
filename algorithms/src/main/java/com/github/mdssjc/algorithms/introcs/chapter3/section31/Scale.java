package com.github.mdssjc.algorithms.introcs.chapter3.section31;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.Picture;

/**
 * Program 3.1.5 Image scaling.
 * <p>
 * Compilation:  javac Scale.java
 * Execution:    java Scale filename w h
 * Data files:   http://www.cs.princeton.edu/introcs/31datatype/mandrill.jpg
 * <p>
 * Scales an image to w-by-h and displays both the original
 * and the scaled version to the screen.
 * <p>
 * % java Scale mandrill.jpg 200 300
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = {"mandrill.jpg", "200", "300"}, valueFile = true)
public class Scale {

  public static void main(final String[] args) {
    Executor.execute(Scale.class, args);

    final var filename = args[0];
    final var width = Integer.parseInt(args[1]);
    final var height = Integer.parseInt(args[2]);
    final var source = new Picture(filename);
    final var target = new Picture(width, height);

    for (var targetCol = 0; targetCol < width; targetCol++) {
      for (var targetRow = 0; targetRow < height; targetRow++) {
        final var sourceCol = targetCol * source.width() / width;
        final var sourceRow = targetRow * source.height() / height;
        final var color = source.get(sourceCol, sourceRow);
        target.set(targetCol, targetRow, color);
      }
    }

    source.show();
    target.show();
  }
}
