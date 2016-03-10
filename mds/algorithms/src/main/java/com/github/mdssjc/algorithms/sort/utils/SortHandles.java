package com.github.mdssjc.algorithms.sort.utils;

public interface SortHandles {

  public static boolean less(final Comparable v, final Comparable w) {
    return v.compareTo(w) < 0;
  }

  public static void exch(final Comparable[] a, final int i, final int j) {
    final Comparable swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }

  public static boolean isSorted(final Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      if (SortHandles.less(a[i], a[i - 1])) {
        return false;
      }
    }
    return true;
  }

  public static boolean isSorted(final Comparable[] a, final int lo,
      final int hi) {
    for (int i = lo; i < hi; i++) {
      if (less(a[i], a[i - 1])) {
        return false;
      }
    }
    return true;
  }
}
