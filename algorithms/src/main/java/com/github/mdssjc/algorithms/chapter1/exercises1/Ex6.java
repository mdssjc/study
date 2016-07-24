package com.github.mdssjc.algorithms.chapter1.exercises1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 6.
 * 
 * @author Marcelo dos Santos
 *
 */
public class Ex6 {

  public static void main(final String[] args) {
    // Fibonacci
    int f = 0;
    int g = 1;

    for (int i = 0; i <= 15; i++) {
      StdOut.println(f);
      f = f + g;
      g = f - g;
    }
  }
}
