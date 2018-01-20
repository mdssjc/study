package com.github.mdssjc.algorithms.introcs.chapter1.exercises13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Exercise 1.3.2.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"6", "10", "-1"})
@TestDrive({"60", "10", "1"})
@TestDrive({"0", "10", "-1"})
public class Ex2 {

  public static void main(final String[] args) {
    Executor.execute(Ex2.class, args);

    final double a = Double.parseDouble(args[0]);
    final double b = Double.parseDouble(args[1]);
    final double c = Double.parseDouble(args[2]);

    if (a == 0.0) {
      System.out.println("Division by zero");
    } else {
      final double discriminant = b * b - 4.0 * a * c;
      if (discriminant < 0.0) {
        System.out.println("Neither of the solutions are real numbers.");
      } else {
        final double d = Math.sqrt(discriminant);
        System.out.println((-b + d) / 2.0 * a);
        System.out.println((-b - d) / 2.0 * a);
      }
    }
  }
}
