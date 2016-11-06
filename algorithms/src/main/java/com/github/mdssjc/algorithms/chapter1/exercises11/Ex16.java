package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 16.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex16 {

  public static void main(final String[] args) {
    Executor.execute(Ex16.class, args);

    StdOut.println(exR1(6));
  }

  private static String exR1(final int n) {
    if (n <= 0) {
      return "";
    }
    return exR1(n - 3) + n + exR1(n - 2) + n;
  }
}
