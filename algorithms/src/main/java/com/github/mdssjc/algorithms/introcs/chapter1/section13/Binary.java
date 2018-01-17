package com.github.mdssjc.algorithms.introcs.chapter1.section13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.3.7 Converting to binary.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("19")
@TestDrive("100000000")
public class Binary {

  public static void main(final String[] args) {
    Executor.execute(Binary.class, args);

    int n = Integer.parseInt(args[0]);
    int power = 1;
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
