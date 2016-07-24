package com.github.mdssjc.algorithms.chapter1.exercises1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 15.
 * 
 * @author Marcelo dos Santos
 *
 */
public class Ex15 {

  public static void main(final String[] args) {
    final int[] a = { 0, 2, 2, 1, 1, 1 };

    for (final int value : histogram(a, a.length)) {
      StdOut.print(value + " ");
    }
  }

  private static int[] histogram(final int[] a, final int length) {
    final int[] res = new int[length];

    for (int i = 0; i < res.length; i++) {
      if (a[i] < 0 || a[i] > length - 1) {
        throw new IllegalArgumentException();
      }
      res[a[i]]++;
    }

    return res;
  }
}
