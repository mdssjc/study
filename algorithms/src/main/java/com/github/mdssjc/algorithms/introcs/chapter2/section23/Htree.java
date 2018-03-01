package com.github.mdssjc.algorithms.introcs.chapter2.section23;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdDraw;

/**
 * Program 2.3.4 Recursive graphics.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("3")
@TestDrive("4")
@TestDrive("5")
public class Htree {

  public static void draw(final int n, final double size, final double x, final double y) {
    if (n == 0) {
      return;
    }

    final double x0 = x - size / 2;
    final double x1 = x + size / 2;
    final double y0 = y - size / 2;
    final double y1 = y + size / 2;

    StdDraw.line(x0, y, x1, y);
    StdDraw.line(x0, y0, x0, y1);
    StdDraw.line(x1, y0, x1, y1);

    draw(n - 1, size / 2, x0, y0);
    draw(n - 1, size / 2, x0, y1);
    draw(n - 1, size / 2, x1, y0);
    draw(n - 1, size / 2, x1, y1);
  }

  public static void main(final String[] args) {
    Executor.execute(Htree.class, args);

    final int n = Integer.parseInt(args[0]);
    draw(n, 0.5, 0.5, 0.5);
  }
}
