package com.github.mdssjc.algorithms.introcs.chapter3.section31;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

/**
 * Program 3.1.2 Albers squares.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"9", "90", "166", "100", "100", "100"})
public class AlbersSquares {

  public static void main(final String[] args) {
    Executor.execute(AlbersSquares.class, args);

    final int r1 = Integer.parseInt(args[0]);
    final int g1 = Integer.parseInt(args[1]);
    final int b1 = Integer.parseInt(args[2]);
    final Color c1 = new Color(r1, g1, b1);

    final int r2 = Integer.parseInt(args[3]);
    final int g2 = Integer.parseInt(args[4]);
    final int b2 = Integer.parseInt(args[5]);
    final Color c2 = new Color(r2, g2, b2);

    StdDraw.setPenColor(c1);
    StdDraw.filledSquare(.25, 0.5, 0.2);
    StdDraw.setPenColor(c2);
    StdDraw.filledSquare(.25, 0.5, 0.1);
    StdDraw.setPenColor(c2);
    StdDraw.filledSquare(.75, 0.5, 0.2);
    StdDraw.setPenColor(c1);
    StdDraw.filledSquare(.75, 0.5, 0.1);
  }
}
