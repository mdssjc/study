package com.github.mdssjc.algorithms.chapter1.exercises11;

import java.util.Arrays;
import java.util.function.IntPredicate;

/**
 * BinarySearchCEx29 Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class BinarySearchCEx29 {

  public static int rank(final int key, final int[] a) {
    return rank(key, a, e -> e < key);
  }

  public static int count(final int key, final int[] a) {
    return rank(key, a, e -> e == key);
  }

  private static int rank(final int key, final int[] a,
                          final IntPredicate predicate) {
    if (rank(key, a, 0, a.length - 1) != -1) {
      return (int) Arrays.stream(a)
                         .filter(predicate)
                         .count();
    }
    return 0;
  }

  private static int rank(final int key, final int[] a, final int lo,
                          final int hi) {
    if (lo > hi) {
      return -1;
    }
    final int mid = lo + (hi - lo) / 2;
    if (key < a[mid]) {
      return rank(key, a, lo, mid - 1);
    } else if (key > a[mid]) {
      return rank(key, a, mid + 1, hi);
    } else {
      return mid;
    }
  }
}
