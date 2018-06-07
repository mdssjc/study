package com.github.mdssjc.algorithms.introcs.chapter3.section31;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

/**
 * Program 3.1.2 Albers squares.
 * <p>
 * Compilation:  javac AlbersSquares.java
 * Execution:    java AlbersSquares r1 g1 b1 r2 g2 b2
 * Dependencies: StdDraw.java
 * <p>
 * This program displays the colors entered in RGB format
 * on the command line in the familiar format developed
 * in the 1960s by the color theorist Josef Albers that
 * revolutionized the way that people think about color.
 * <p>
 * % java AlbersSquares 0 174 239  147 149 252
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"0", "174", "239", "147", "149", "252"})
public class AlbersSquares {

  public static void main(final String[] args) {
    Executor.execute(AlbersSquares.class, args);

    StdDraw.setCanvasSize(800, 800);

    final var r1 = Integer.parseInt(args[0]);
    final var g1 = Integer.parseInt(args[1]);
    final var b1 = Integer.parseInt(args[2]);
    final var c1 = new Color(r1, g1, b1);

    final var r2 = Integer.parseInt(args[3]);
    final var g2 = Integer.parseInt(args[4]);
    final var b2 = Integer.parseInt(args[5]);
    final var c2 = new Color(r2, g2, b2);

    StdDraw.setPenColor(c1);
    StdDraw.filledSquare(0.25, 0.5, 0.2);
    StdDraw.setPenColor(c2);
    StdDraw.filledSquare(0.25, 0.5, 0.1);

    StdDraw.setPenColor(c2);
    StdDraw.filledSquare(0.75, 0.5, 0.2);
    StdDraw.setPenColor(c1);
    StdDraw.filledSquare(0.75, 0.5, 0.1);
  }
}
