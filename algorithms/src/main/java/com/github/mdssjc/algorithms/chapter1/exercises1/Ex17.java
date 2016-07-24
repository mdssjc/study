package com.github.mdssjc.algorithms.chapter1.exercises1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 17.
 * 
 * @author Marcelo dos Santos
 *
 */
public class Ex17 {

  public static void main(final String[] args) {
    StdOut.println(exR2(3)); // StackOverflowError
  }

  public static String exR2(final int n) {
    final String s = exR2(n - 3) + n + exR2(n - 2) + n;
    if (n <= 0) {
      return "";
    }
    return s;
  }
}
