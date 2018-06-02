package com.github.mdssjc.algorithms.introcs.chapter1.section15;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdIn;

/**
 * Program 1.5.5 Standard input-to-drawing filter.
 * <p>
 * Compilation:  javac PlotFilter.java
 * Execution:    java PlotFilter < input.txt
 * Dependencies: StdDraw.java StdIn.java
 * <p>
 * % java PlotFilter < USA.txt
 * <p>
 * Datafiles:    http://www.cs.princeton.edu/IntroProgramming/15inout/USA.txt
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "USA.txt", inputFile = true)
public class PlotFilter {

  public static void main(final String[] args) {
    Executor.execute(PlotFilter.class, args);

    final var x0 = StdIn.readDouble();
    final var y0 = StdIn.readDouble();
    final var x1 = StdIn.readDouble();
    final var y1 = StdIn.readDouble();
    StdDraw.setXscale(x0, x1);
    StdDraw.setYscale(y0, y1);

    StdDraw.setPenRadius(0.005);

    StdDraw.enableDoubleBuffering();

    while (!StdIn.isEmpty()) {
      final var x = StdIn.readDouble();
      final var y = StdIn.readDouble();
      StdDraw.point(x, y);
    }

    StdDraw.show();
  }
}
