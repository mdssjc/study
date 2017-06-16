package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.chapter1.section11.Euclid;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 1.1.25.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex25 {

  public static void main(final String[] args) {
    Executor.execute(Ex25.class, args);

    final int p = 4;
    final int q = 2;

    final boolean result1 = Euclid.gcd(p, 0) == p;
    final boolean result2 = Euclid.gcd(p, q) == Euclid.gcd(q, p % q);

    StdOut.println(result1);
    StdOut.println(result2);
  }
}
