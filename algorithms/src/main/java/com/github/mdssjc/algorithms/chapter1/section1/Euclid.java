package com.github.mdssjc.algorithms.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class Euclid {

  public static int gcd(final int p, final int q) {
    if (q == 0) {
      return p;
    }
    final int r = p % q;
    return gcd(q, r);
  }

  public static void main(final String[] args) {
    StdOut.println(gcd(10, 12));
  }
}
