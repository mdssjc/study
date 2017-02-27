package com.github.mdssjc.algorithms.sort.concrete;

import com.github.mdssjc.algorithms.sort.Sort;

import java.util.Comparator;

/**
 * Insertion Sort (N² / Stable).
 *
 * @author Marcelo dos Santos
 *
 */
public class InsertionSort<T> implements Sort<T> {

  public void sort(final Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
        exch(a, j, j - 1);
      }
    }
  }

  public void sort(final T[] a, final Comparator c) {
    final int N = a.length;
    for (int i = 1; i < N; i++) {
      for (int j = i; j > 0 && less(c, a[j], a[j - 1]); j--) {
        exch(a, j, j - 1);
      }
    }
  }
}
