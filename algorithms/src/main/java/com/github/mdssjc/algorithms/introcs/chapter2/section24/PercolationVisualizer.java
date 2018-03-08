package com.github.mdssjc.algorithms.introcs.chapter2.section24;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdDraw;

/**
 * Program 2.4.3 Visualization client.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"20", "0.9"})
@TestDrive({"20", "0.95"})
public class PercolationVisualizer {

  public static void main(final String[] args) {
    Executor.execute(PercolationVisualizer.class, args);

    final int n = Integer.parseInt(args[0]);
    final double p = Double.parseDouble(args[1]);
    StdDraw.enableDoubleBuffering();

    final boolean[][] isOpen = PercolationVertical.random(n, p);
    StdDraw.setPenColor(StdDraw.BLACK);
    PercolationVertical.show(isOpen, false);

    StdDraw.setPenColor(StdDraw.BOOK_BLUE);
    final boolean[][] isFull = PercolationVertical.flow(isOpen);
    PercolationVertical.show(isFull, true);

    StdDraw.show();
  }
}
