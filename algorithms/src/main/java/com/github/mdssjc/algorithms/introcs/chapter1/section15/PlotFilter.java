package com.github.mdssjc.algorithms.introcs.chapter1.section15;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdIn;

/**
 * Program 1.5.5 Standard input-to-drawing filter.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "USA.txt", inputFile = true)
public class PlotFilter {

  public static void main(final String[] args) {
    Executor.execute(PlotFilter.class, args);

    final double x0 = StdIn.readDouble();
    final double y0 = StdIn.readDouble();
    final double x1 = StdIn.readDouble();
    final double y1 = StdIn.readDouble();

    StdDraw.setXscale(x0, x1);
    StdDraw.setYscale(y0, y1);

    while (!StdIn.isEmpty()) {
      final double x = StdIn.readDouble();
      final double y = StdIn.readDouble();
      StdDraw.point(x, y);
    }
  }
}
