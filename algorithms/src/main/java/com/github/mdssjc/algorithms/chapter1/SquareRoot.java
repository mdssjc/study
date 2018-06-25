package com.github.mdssjc.algorithms.chapter1;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Square Root.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("2")
public class SquareRoot {

  public static double sqrt(final double c) {
    if (c < 0) {
      return Double.NaN;
    }

    final var err = 1e-15;
    var t = c;
    while (Math.abs(t - c / t) > err * t) {
      t = (c / t + t) / 2.0;
    }

    return t;
  }

  public static void main(final String[] args) {
    Executor.execute(SquareRoot.class, args);

    final var value = Double.parseDouble(args[0]);

    StdOut.println(Math.sqrt(value));
    StdOut.println(sqrt(value));
  }
}
