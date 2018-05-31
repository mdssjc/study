package com.github.mdssjc.algorithms.introcs.chapter1.section13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.3.7 Converting to binary.
 * <p>
 * Compilation:  javac Binary.java
 * Execution:    java Binary n
 * <p>
 * Prints out n in binary.
 * <p>
 * % java Binary 5
 * 101
 * <p>
 * % java Binary 106
 * 1101010
 * <p>
 * % java Binary 0
 * 0
 * <p>
 * % java Binary 16
 * 10000
 * <p>
 * Limitations
 * -----------
 * Does not handle negative integers.
 * <p>
 * Remarks
 * -------
 * could use Integer.toBinaryString(N) instead.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("5")
@TestDrive("106")
@TestDrive("0")
@TestDrive("16")
public class Binary {

  public static void main(final String[] args) {
    Executor.execute(Binary.class, args);

    var n = Integer.parseInt(args[0]);

    var power = 1;
    while (power <= n / 2) {
      power *= 2;
    }

    while (power > 0) {
      if (n < power) {
        System.out.print(0);
      } else {
        System.out.print(1);
        n -= power;
      }

      power /= 2;
    }

    System.out.println();
  }
}
