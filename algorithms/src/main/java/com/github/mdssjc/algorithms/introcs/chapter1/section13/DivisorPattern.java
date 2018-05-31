package com.github.mdssjc.algorithms.introcs.chapter1.section13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.3.4 Your first nested loops.
 * <p>
 * Compilation:  javac DivisorPattern.java
 * Execution:    java DivisorPattern n
 * <p>
 * Prints a table where entry (i, j) is a '* ' if i divides j
 * or j divides i and '. ' otherwise.
 * <p>
 * <p>
 * % java DivisorPattern 20
 * * * * * * * * * * * * * * * * * * * * * 1
 * * *   *   *   *   *   *   *   *   *   * 2
 * *   *     *     *     *     *     *     3
 * * *   *       *       *       *       * 4
 * *       *         *         *         * 5
 * * * *     *           *           *     6
 * *           *             *             7
 * * *   *       *               *         8
 * *   *           *                 *     9
 * * *     *         *                   * 10
 * *                   *                   11
 * * * * *   *           *                 12
 * *                       *               13
 * * *         *             *             14
 * *   *   *                   *           15
 * * *   *       *               *         16
 * *                               *       17
 * * * *     *     *                 *     18
 * *                                   *   19
 * * *   * *         *                   * 20
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("20")
public class DivisorPattern {

  public static void main(final String[] args) {
    Executor.execute(DivisorPattern.class, args);

    final var n = Integer.parseInt(args[0]);

    for (var i = 1; i <= n; i++) {
      for (var j = 1; j <= n; j++) {
        if (i % j == 0 || j % i == 0) {
          System.out.print("* ");
        }
        else {
          System.out.print("  ");
        }
      }
      System.out.println(i);
    }
  }
}
