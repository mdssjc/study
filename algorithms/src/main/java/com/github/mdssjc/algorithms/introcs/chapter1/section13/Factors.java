package com.github.mdssjc.algorithms.introcs.chapter1.section13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.3.9 Factoring integers.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("3757208")
@TestDrive("287994837222311")
public class Factors {

  public static void main(final String[] args) {
    Executor.execute(Factors.class, args);

    long n = Long.parseLong(args[0]);
    for (long factor = 2; factor <= n / factor; factor++) {
      while (n % factor == 0) {
        n /= factor;
        System.out.print(factor + " ");
      }
    }
    if (n > 1) {
      System.out.print(n);
    }
    System.out.println();
  }
}
