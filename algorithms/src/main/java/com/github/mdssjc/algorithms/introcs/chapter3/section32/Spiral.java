package com.github.mdssjc.algorithms.introcs.chapter3.section32;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 3.2.5 Spira mirabilis.
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

    final int n = Integer.parseInt(args[0]);
    final double decay = Double.parseDouble(args[1]);
    final double angle = 360.0 / n;
    double step = Math.sin(Math.toRadians(angle / 2));
    final Turtle turtle = new Turtle(0.5, 0, angle / 2);

    for (int i = 0; i < 10 * 360 / angle; i++) {
      step /= decay;
      turtle.goForward(step);
      turtle.turnLeft(angle);
    }
  }
}
