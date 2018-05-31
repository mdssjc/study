package com.github.mdssjc.algorithms.introcs.chapter1.section13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.3.3 Computing powers of 2.
 * <p>
 * Compilation:  javac PowersOfTwo.java
 * Execution:    java PowersOfTwo n
 * <p>
 * This program takes a command-line argument n and prints a table of
 * the powers of 2 that are less than or equal to 2^n.
 * <p>
 * % java PowersOfTwo 5
 * 0 1
 * 1 2
 * 2 4
 * 3 8
 * 4 16
 * 5 32
 * <p>
 * % java PowersOfTwo 6
 * 0 1
 * 1 2
 * 2 4
 * 3 8
 * 4 16
 * 5 32
 * 6 64
 * <p>
 * Remarks
 * ------------
 * Only works if 0 <= n < 31 since 2^31 overflows an int.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("5")
@TestDrive("6")
public class PowersOfTwo {

  public static void main(final String[] args) {
    Executor.execute(PowersOfTwo.class, args);

    final var n = Integer.parseInt(args[0]);

    var i = 0;
    var powerOfTwo = 1;

    while (i <= n) {
      System.out.println(i + " " + powerOfTwo);
      powerOfTwo = 2 * powerOfTwo;
      i = i + 1;
    }
  }
}
