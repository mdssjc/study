package com.github.mdssjc.algorithms.introcs.chapter1.section13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.3.4 Your first nested loops.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("3")
@TestDrive("12")
public class DivisorPattern {

  public static void main(final String[] args) {
    Executor.execute(DivisorPattern.class, args);

    final int n = Integer.parseInt(args[0]);
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if ((i % j == 0) || (j % i == 0)) {
          System.out.print("* ");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println(i);
    }
  }
}
