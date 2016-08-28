package com.github.mdssjc.algorithms.chapter1.exercises12;

import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 7.
 * 
 * @author Marcelo dos Santos
 *
 */
public class Ex7 {

  public static void main(final String[] args) {
    StdOut.println(mystery("marcelo"));
  }

  public static String mystery(final String s) {
    final int N = s.length();
    if (N <= 1) {
      return s;
    }
    final String a = s.substring(0, N / 2);
    final String b = s.substring(N / 2, N);
    return mystery(b) + mystery(a);
  }
}
