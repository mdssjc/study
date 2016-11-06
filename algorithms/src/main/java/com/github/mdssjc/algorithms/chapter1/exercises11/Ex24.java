package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 24.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( {"105", "24"} )
@TestDrive( {"1111111", "1234567"} )
public class Ex24 {

  public static void main(final String[] args) {
    Executor.execute(Ex24.class, args);

    final int arg1 = Integer.parseInt(args[0]);
    final int arg2 = Integer.parseInt(args[1]);

    StdOut.println("gcd: " + gcd(arg1, arg2));
  }

  private static int gcd(final int p, final int q) {
    StdOut.printf("p: %7d, q: %7d%n", p, q);

    if (q == 0) {
      return p;
    }
    final int r = p % q;
    return gcd(q, r);
  }
}
