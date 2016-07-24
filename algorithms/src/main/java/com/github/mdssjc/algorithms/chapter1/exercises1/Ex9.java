package com.github.mdssjc.algorithms.chapter1.exercises1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 9.
 * 
 * @author Marcelo dos Santos
 *
 */
public class Ex9 {

  public static void main(final String[] args) {
    final int N = 5;

    String s = Integer.toBinaryString(N);
    StdOut.println(s);

    s = "";
    for (int n = N; n > 0; n /= 2) {
      s = (n % 2) + s;
    }
    StdOut.println(s);
  }
}
