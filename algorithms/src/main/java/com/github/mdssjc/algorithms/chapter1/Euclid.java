package com.github.mdssjc.algorithms.chapter1;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Euclid's algorithm.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Euclid {

  public static int gcd(final int p, final int q) {
    if (q == 0) {
      return p;
    }
    final var r = p % q;
    return gcd(q, r);
  }

  public static void main(final String[] args) {
    Executor.execute(Euclid.class, args);

    StdOut.println(gcd(10, 12));
  }
}
