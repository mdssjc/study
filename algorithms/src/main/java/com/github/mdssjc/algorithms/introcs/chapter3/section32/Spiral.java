package com.github.mdssjc.algorithms.introcs.chapter3.section32;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 3.2.5 Spira mirabilis.
 * <p>
 * Compilation:  javac Spiral.java
 * Execution:    java Spiral
 * Dependencies: Turtle.java
 * <p>
 * Plots a logarithmic spiral.
 * <p>
 * % java Spiral 3 1.0         // equilateral triangle
 * <p>
 * % java Spiral 3 1.2
 * <p>
 * % java Spiral 1440 1.00004
 * <p>
 * % java Spiral 1440 1.0004  // logarithmic spiral
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"3", "1.0"})
@TestDrive({"3", "1.2"})
@TestDrive({"1440", "1.00004"})
@TestDrive({"1440", "1.0004"})
public class Spiral {

  public static void main(final String[] args) {
    Executor.execute(Spiral.class, args);

    final var n = Integer.parseInt(args[0]);
    final var decay = Double.parseDouble(args[1]);

    final var angle = 360.0 / n;
    var step = Math.sin(Math.toRadians(angle / 2.0));
    final var turtle = new Turtle(0.5, 0.0, angle / 2.0);
    for (var i = 0; i < 10 * n; i++) {
      step /= decay;
      turtle.goForward(step);
      turtle.turnLeft(angle);
    }
  }
}
