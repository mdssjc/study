package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 17.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex17 {

  public static void main(final String[] args) {
    Executor.execute(Ex17.class, args);

    StdOut.println(exR2(3)); // StackOverflowError
  }

  private static String exR2(final int n) throws RuntimeException {
    final String s = exR2(n - 3) + n + exR2(n - 2) + n;
    if (n <= 0) {
      return "";
    }
    return s;
  }
}
