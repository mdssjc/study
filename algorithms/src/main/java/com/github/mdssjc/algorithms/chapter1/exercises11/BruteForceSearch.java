package com.github.mdssjc.algorithms.chapter1.exercises11;

/**
 * BruteForceSearch Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class BruteForceSearch {

  public static int rank(final int key, final int[] a) {
    for (int i = 0; i < a.length; i++) {
      if (a[i] == key) return i;
    }
    return -1;
  }
}
