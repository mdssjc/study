package com.github.mdssjc.algorithms.chapter1.exercises1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 16.
 * 
 * @author Marcelo dos Santos
 *
 */
public class Ex16 {

  public static void main(final String[] args) {
    StdOut.println(exR1(6));
  }

  public static String exR1(final int n) {
    if (n <= 0) {
      return "";
    }
    return exR1(n - 3) + n + exR1(n - 2) + n;
  }
}
