package com.github.mdssjc.algorithms.introcs.chapter1.section13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.3.6 Newton’s method.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("2.0")
@TestDrive("2544545")
public class Sqrt {

  public static void main(final String[] args) {
    Executor.execute(Sqrt.class, args);

    final double c = Double.parseDouble(args[0]);
    final double EPSILON = 1e-15;
    double t = c;
    while (Math.abs(t - c / t) > EPSILON * t) {
      t = (c / t + t) / 2.0;
    }
    System.out.println(t);
  }
}
