package com.github.mdssjc.algorithms.introcs.chapter1.section13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.3.6 Newton’s method.
 * <p>
 * Compilation:  javac Sqrt.java
 * Execution:    java Sqrt c
 * <p>
 * Computes the square root of a nonnegative number c using
 * Newton's method:
 * - initialize t = c
 * - replace t with the average of c/t and t
 * - repeat until desired accuracy reached
 * <p>
 * % java Sqrt 2
 * 1.414213562373095
 * <p>
 * % java Sqrt 1000000
 * 1000.0
 * <p>
 * % java Sqrt 0.4
 * 0.6324555320336759
 * <p>
 * % java Sqrt 1048575
 * 1023.9995117186336
 * <p>
 * % java Sqrt 16664444
 * 4082.2106756021303
 * <p>
 * % java Sqrt 0
 * 0.0
 * <p>
 * % java Sqrt 1e-50
 * 9.999999999999999E-26
 * <p>
 * <p>
 * Remarks
 * ----------
 * - using Math.abs() is required if c < 1
 * <p>
 * <p>
 * Known bugs
 * ----------
 * - goes into an infinite loop if the input is negative
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("2.0")
@TestDrive("1000000")
@TestDrive("0.4")
@TestDrive("1048575")
@TestDrive("16664444")
@TestDrive("0")
@TestDrive("1e-50")
public class Sqrt {

  public static void main(final String[] args) {
    Executor.execute(Sqrt.class, args);

    final var c = Double.parseDouble(args[0]);
    final var epsilon = 1e-15;
    var t = c;

    while (Math.abs(t - c / t) > epsilon * t) {
      t = (c / t + t) / 2.0;
    }

    System.out.println(t);
  }
}
