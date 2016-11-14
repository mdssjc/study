package com.github.mdssjc.algorithms.utils;

/**
 * SortHandles.
 *
 * @author Marcelo dos Santos
 *
 */
public interface SortHandles {

  static boolean less(final Comparable v, final Comparable w) {
    return v.compareTo(w) < 0;
  }

  static void exch(final Comparable[] a, final int i, final int j) {
    final Comparable swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }

  static boolean isSorted(final Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      if (less(a[i], a[i - 1])) {
        return false;
      }
    }
    return true;
  }

  static boolean isSorted(final Comparable[] a, final int lo, final int hi) {
    for (int i = lo + 1; i <= hi; i++) {
      if (less(a[i], a[i - 1])) {
        return false;
      }
    }
    return true;
  }
}
