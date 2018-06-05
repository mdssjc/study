package com.github.mdssjc.algorithms.introcs.chapter2.section23;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 2.3.1 Euclid’s algorithm.
 * <p>
 * Compilation:  javac Euclid.java
 * Execution:    java Euclid p q
 * <p>
 * Reads two command-line arguments p and q and computes the greatest
 * common divisor of p and q using Euclid's algorithm.
 * <p>
 * Remarks
 * -----------
 * - may return the negative of the gcd if p is negative
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"1440", "408"})
@TestDrive({"314159", "271828"})
public class Euclid {

  public static int gcd(final int p, final int q) {
    if (q == 0) {
      return p;
    } else {
      return gcd(q, p % q);
    }
  }

  public static int gcd2(int p, int q) {
    while (q != 0) {
      final var temp = q;
      q = p % q;
      p = temp;
    }
    return p;
  }

  public static void main(final String[] args) {
    Executor.execute(Euclid.class, args);

    final var p = Integer.parseInt(args[0]);
    final var q = Integer.parseInt(args[1]);
    final var d = gcd(p, q);
    final var d2 = gcd2(p, q);
    StdOut.println("gcd(" + p + ", " + q + ") = " + d);
    StdOut.println("gcd(" + p + ", " + q + ") = " + d2);
  }
}
