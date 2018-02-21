package com.github.mdssjc.algorithms.introcs.chapter2.section22;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdDraw;

/**
 * Program 2.2.3 Iterated function systems.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = "10000", input = "sierpinski.txt", inputFile = true)
@TestDrive(value = "20000", input = "barnsley.txt", inputFile = true)
@TestDrive(value = "20000", input = "tree.txt", inputFile = true)
@TestDrive(value = "20000", input = "coral.txt", inputFile = true)
public class IFS {

  public static void main(final String[] args) {
    Executor.execute(IFS.class, args);

    final int trials = Integer.parseInt(args[0]);

    final double[] dist = StdArrayIO.readDouble1D();
    final double[][] cx = StdArrayIO.readDouble2D();
    final double[][] cy = StdArrayIO.readDouble2D();

    double x = 0.0, y = 0.0;
    for (int t = 0; t < trials; t++) {
      final int r = StdRandom.discrete(dist);
      final double x0 = cx[r][0] * x + cx[r][1] * y + cx[r][2];
      final double y0 = cy[r][0] * x + cy[r][1] * y + cy[r][2];
      x = x0;
      y = y0;
      StdDraw.point(x, y);
    }
  }
}
