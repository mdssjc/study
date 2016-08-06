package com.github.mdssjc.algorithms.chapter1.exercises11;

import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 10.
 * 
 * @author Marcelo dos Santos
 *
 */
public class Ex10 {

  public static void main(final String[] args) {
    // final int[] a;
    final int[] a = new int[10];

    for (int i = 0; i < 10; i++) {
      a[i] = i * i;
    }

    for (final int value : a) {
      StdOut.println(value);
    }
  }
}
