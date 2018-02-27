package com.github.mdssjc.algorithms.introcs.chapter2.section23;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 2.3.1 Euclid’s algorithm.
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
    }
    return gcd(q, p % q);
  }

  public static void main(final String[] args) {
    Executor.execute(Euclid.class, args);

    final int p = Integer.parseInt(args[0]);
    final int q = Integer.parseInt(args[1]);
    final int divisor = gcd(p, q);
    StdOut.println(divisor);
  }
}
