package com.github.mdssjc.algorithms.introcs.chapter2.section23;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdDraw;

/**
 * Program 2.3.4 Recursive graphics.
 * <p>
 * Compilation:  javac Htree.java
 * Execution:    java Htree n
 * Dependencies: StdDraw.java
 * <p>
 * Plot an order n H-tree.
 * <p>
 * % java Htree 5
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("5")
public class Htree {

  public static void drawH(final double x, final double y, final double size) {
    final var x0 = x - size / 2;
    final var x1 = x + size / 2;
    final var y0 = y - size / 2;
    final var y1 = y + size / 2;

    StdDraw.line(x0, y0, x0, y1);
    StdDraw.line(x1, y0, x1, y1);
    StdDraw.line(x0,  y, x1,  y);
  }

  public static void draw(final int n, final double x, final double y, final double size) {
    if (n == 0) {
      return;
    }
    drawH(x, y, size);

    final var x0 = x - size / 2;
    final var x1 = x + size / 2;
    final var y0 = y - size / 2;
    final var y1 = y + size / 2;

    draw(n-1, x0, y0, size/2);
    draw(n-1, x0, y1, size/2);
    draw(n-1, x1, y0, size/2);
    draw(n-1, x1, y1, size/2);
  }

  public static void main(final String[] args) {
    Executor.execute(Htree.class, args);

    final var n = Integer.parseInt(args[0]);

    final var x = 0.5;
    final var y = 0.5;
    final var size = 0.5;
    draw(n, x, y, size);
  }
}
