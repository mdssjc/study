package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 18.
 * 
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex18 {

  public static void main(final String[] args) {
    Executor.execute(Ex18.class, args);

    StdOut.println(mystery(2, 25));
    StdOut.println(mystery(3, 11));
    StdOut.println(mystery(4, 12));

    StdOut.println(mystery2(2, 25));
    StdOut.println(mystery2(3, 11));
    StdOut.println(mystery2(4, 12));
  }

  private static int mystery(final int a, final int b) {
    if (b == 0) {
      return 0;
    }
    if (b % 2 == 0) {
      return mystery(a + a, b / 2);
    }
    return mystery(a + a, b / 2) + a;
  }

  private static int mystery2(final int a, final int b) {
    if (b == 0) {
      return 1;
    }
    if (b % 2 == 0) {
      return mystery(a * a, b / 2);
    }
    return mystery(a * a, b / 2) * a;
  }
}
