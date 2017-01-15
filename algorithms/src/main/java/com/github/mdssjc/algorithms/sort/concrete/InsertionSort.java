package com.github.mdssjc.algorithms.sort.concrete;

import com.github.mdssjc.algorithms.sort.Sort;

/**
 * Insertion Sort (N² / Stable).
 *
 * @author Marcelo dos Santos
 *
 */
public class InsertionSort implements Sort {

  public void sort(final Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      for (int j = i; j > 0 && Sort.less(a[j], a[j - 1]); j--) {
        Sort.exch(a, j, j - 1);
      }
    }
  }
}
