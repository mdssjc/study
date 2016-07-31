package com.github.mdssjc.algorithms.chapter1.exercises1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 24.
 * 
 * @author Marcelo dos Santos
 *
 */
public class Ex24 {

  public static void main(final String[] args) {
    final int arg1 = Integer.parseInt(args[0]);
    final int arg2 = Integer.parseInt(args[1]);

    StdOut.println("gcd: " + gcd(arg1, arg2));
  }

  public static int gcd(final int p, final int q) {
    StdOut.printf("p: %d, q: %d%n", p, q);

    if (q == 0) {
      return p;
    }
    final int r = p % q;
    return gcd(q, r);
  }
}
