package com.github.mdssjc.algorithms.introcs.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Exercise 1.2.2.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("0")
@TestDrive("1")
@TestDrive("2.07")
@TestDrive("3.14")
@TestDrive("6.28")
public class Ex2 {

  public static void main(final String[] args) {
    Executor.execute(Ex2.class, args);

    final double radians = Double.parseDouble(args[0]);
    final double result = Math.pow(Math.cos(radians), 2) +
                          Math.pow(Math.sin(radians), 2);

    System.out.printf("x = %.2f -> %.2f%n", radians, result);
  }
}
