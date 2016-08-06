package com.github.mdssjc.algorithms.chapter1.exercises11;

import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 5.
 * 
 * @author Marcelo dos Santos
 *
 */
public class Ex5 {

  public static void main(final String[] args) {
    StdOut.println(check(1E-6, 1E-3));
    StdOut.println(check(0, 1));
    StdOut.println(check(0.5, 0.5));
  }

  public static boolean check(final double x, final double y) {
    return (x > 0.0 && x < 1.0) && (y > 0.0 && y < 1.0);
  }
}
