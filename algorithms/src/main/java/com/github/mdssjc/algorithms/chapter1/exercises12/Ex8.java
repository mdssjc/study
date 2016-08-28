package com.github.mdssjc.algorithms.chapter1.exercises12;

import java.util.stream.IntStream;

import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 8.
 * 
 * @author Marcelo dos Santos
 *
 */
public class Ex8 {

  public static void main(final String[] args) {
    int[] a = IntStream.range(0, 1000)
      .toArray();
    int[] b = IntStream.range(1000, 2000)
      .toArray();

    final int[] t = a;
    a = b;
    b = t;

    StdOut.println(check(a, b));
  }

  private static boolean check(final int[] a, final int[] b) {
    for (int i = 0; i < a.length; i++) {
      if (a[i] != i + 1000 && b[i] != i) {
        return false;
      }
    }
    return true;
  }
}
