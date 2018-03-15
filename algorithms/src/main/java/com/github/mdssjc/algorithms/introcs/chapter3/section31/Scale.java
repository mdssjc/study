package com.github.mdssjc.algorithms.introcs.chapter3.section31;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.Picture;

/**
 * Program 3.1.5 Image scaling.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = {"mandrill.jpg", "800", "800"}, valueFile = true)
@TestDrive(value = {"mandrill.jpg", "600", "300"}, valueFile = true)
@TestDrive(value = {"mandrill.jpg", "200", "400"}, valueFile = true)
@TestDrive(value = {"mandrill.jpg", "200", "200"}, valueFile = true)
public class Scale {

  public static void main(final String[] args) {
    Executor.execute(Scale.class, args);

    final int w = Integer.parseInt(args[1]);
    final int h = Integer.parseInt(args[2]);
    final Picture source = new Picture(args[0]);
    final Picture target = new Picture(w, h);
    for (int colT = 0; colT < w; colT++) {
      for (int rowT = 0; rowT < h; rowT++) {
        final int colS = colT * source.width() / w;
        final int rowS = rowT * source.height() / h;
        target.set(colT, rowT, source.get(colS, rowS));
      }
    }
    source.show();
    target.show();
  }
}
