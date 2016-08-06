package com.github.mdssjc.algorithms.chapter1.exercises11;

import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 14.
 * 
 * @author Marcelo dos Santos
 *
 */
public class Ex14 {

  public static void main(final String[] args) {
    for (int i = 0; i < 1000; i += 2) {
      final int lg = lg(i);
      final double log = Math.log(i) / Math.log(2);

      StdOut.println(i + " " + lg + " " + log);

      if (lg > log && Double.isFinite(log)) {
        throw new RuntimeException();
      }
    }
  }

  public static int lg(final int n) {
    int count = 0;
    int r = 2;

    while (r <= n) {
      count++;
      r *= 2;
    }
    return count;
  }
}
