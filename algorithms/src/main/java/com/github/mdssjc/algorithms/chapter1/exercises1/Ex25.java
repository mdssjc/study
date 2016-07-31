package com.github.mdssjc.algorithms.chapter1.exercises1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 25.
 * 
 * @author Marcelo dos Santos
 *
 */
public class Ex25 {

  public static void main(final String[] args) {
    final int p = 4;
    final int q = 2;

    final boolean res1 = gcd(p, 0) == p;
    final boolean res2 = gcd(p, q) == gcd(q, p % q);

    StdOut.println(res1); // true
    StdOut.println(res2); // true
  }

  public static int gcd(final int p, final int q) {
    if (q == 0) {
      return p;
    }
    final int r = p % q;
    return gcd(q, r);
  }
}
