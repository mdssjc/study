package com.github.mdssjc.algorithms.introcs.chapter1.section12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.2.3 Quadratic formula.
 * <p>
 * Compilation:  javac Quadratic.java
 * Execution:    java Quadatic b c
 * <p>
 * Given b and c, solves for the roots of x*x + b*x + c.
 * Assumes both roots are real valued.
 * <p>
 * % java Quadratic -3.0 2.0
 * 2.0
 * 1.0
 * <p>
 * % java Quadratic -1.0 -1.0
 * 1.618033988749895
 * -0.6180339887498949
 * <p>
 * Remark:  1.6180339... is the golden ratio.
 * <p>
 * % java Quadratic 1.0 1.0
 * NaN
 * NaN
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"-3.0", "2.0"})
@TestDrive({"-1.0", "-1.0"})
@TestDrive({"-1.0", "1.0"})
public class Quadratic {

  public static void main(final String[] args) {
    Executor.execute(Quadratic.class, args);

    final var b = Double.parseDouble(args[0]);
    final var c = Double.parseDouble(args[1]);

    final var discriminant = b * b - 4.0 * c;
    final var sqroot = Math.sqrt(discriminant);

    final var root1 = (-b + sqroot) / 2.0;
    final var root2 = (-b - sqroot) / 2.0;

    System.out.println(root1);
    System.out.println(root2);
  }
}
