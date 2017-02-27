package com.github.mdssjc.algorithms.sort;

import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

/**
 * Sort.
 * <p>
 * Interface do Sort.
 *
 * @author Marcelo dos Santos
 *
 */
public interface Sort<T> {

  default boolean less(final Comparable v, final Comparable w) {
    return v.compareTo(w) < 0;
  }

  default void exch(final Comparable[] a, final int i, final int j) {
    final Comparable swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }

  default void show(final Comparable[] a) {
    for (final Comparable item : a) {
      StdOut.print(item + " ");
    }
    StdOut.println();
  }

  default boolean isSorted(final Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      if (less(a[i], a[i - 1])) {
        return false;
      }
    }
    return true;
  }

  default boolean isSorted(final Comparable[] a, final int lo, final int hi) {
    for (int i = lo + 1; i <= hi; i++) {
      if (less(a[i], a[i - 1])) {
        return false;
      }
    }
    return true;
  }

  default boolean less(final Comparator c, final T v, final T w) {
    return c.compare(v, w) < 0;
  }

  default void exch(final T[] a, final int i, final int j) {
    final T t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  void sort(Comparable[] a);
}
