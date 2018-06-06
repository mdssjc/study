package com.github.mdssjc.algorithms.introcs.chapter2.section24;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdDraw;

/**
 * Program 2.4.3 Visualization client.
 * <p>
 * Compilation:  javac PercolationVisualizer.java
 * Execution:    java PercolationVisualizer n p trials
 * Dependencies: Percolation.java StdDraw.java
 * <p>
 * Repeatedly generated n-by-n boolean matrices, where each site
 * is true with probability p. Plot the results using standard
 * graphics.
 * <p>
 * % java PercolationVisualizer 20 0.35 10
 * <p>
 * % java PercolationVisualizer 20 0.45 10
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"20", "0.35", "10"})
@TestDrive({"20", "0.45", "10"})
public class PercolationVisualizer {

  public static void main(final String[] args) {
    Executor.execute(PercolationVisualizer.class, args);

    final var n = Integer.parseInt(args[0]);
    final var p = Double.parseDouble(args[1]);
    final var trials = Integer.parseInt(args[2]);

    StdDraw.enableDoubleBuffering();
    for (var t = 0; t < trials; t++) {
      final var open = Percolation.random(n, p);
      StdDraw.clear();
      StdDraw.setPenColor(StdDraw.BLACK);
      Percolation.show(open, false);
      StdDraw.setPenColor(StdDraw.GRAY);
      final var full = Percolation.flow(open);
      Percolation.show(full, true);
      StdDraw.show();
      StdDraw.pause(1000);
    }
  }
}
