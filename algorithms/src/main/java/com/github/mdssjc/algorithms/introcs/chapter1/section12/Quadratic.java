package com.github.mdssjc.algorithms.introcs.chapter1.section12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.2.3 Quadratic formula.
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

    final double b = Double.parseDouble(args[0]);
    final double c = Double.parseDouble(args[1]);
    final double discriminant = b * b - 4.0 * c;
    final double d = Math.sqrt(discriminant);
    System.out.println((-b + d) / 2.0);
    System.out.println((-b - d) / 2.0);
  }
}
