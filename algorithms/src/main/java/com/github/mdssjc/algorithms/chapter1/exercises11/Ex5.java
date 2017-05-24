package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 1.1.5.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex5 {

  public static void main(final String[] args) {
    Executor.execute(Ex5.class, args);

    StdOut.println(isBetween0and1(1E-6, 1E-3));
    StdOut.println(isBetween0and1(0, 0));
    StdOut.println(isBetween0and1(0, 1));
    StdOut.println(isBetween0and1(0.5, 0.5));

    StdOut.println(isBetween0and1(-0.1, 0.5));
    StdOut.println(isBetween0and1(0.5, -0.1));
    StdOut.println(isBetween0and1(1.1, 0.5));
    StdOut.println(isBetween0and1(0.5, 1.1));
  }

  private static boolean isBetween0and1(final double x, final double y) {
    return (x >= 0.0) && (x <= 1.0) && (y >= 0.0) && (y <= 1.0);
  }
}
