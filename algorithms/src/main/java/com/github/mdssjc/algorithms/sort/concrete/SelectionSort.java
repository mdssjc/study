package com.github.mdssjc.algorithms.sort.concrete;

import com.github.mdssjc.algorithms.sort.Sort;

/**
 * Selection Sort (~N²/2).
 *
 * - Running time is insensitive to input
 * - Data movement is minimal
 *
 * @author Marcelo dos Santos
 *
 */
public class SelectionSort implements Sort {

  public  void sort(final Comparable[] a) {
    final int n = a.length;

    for (int i = 0; i < n; i++) {
      int min = i;
      for (int j = i + 1; j < n; j++) {
        if (Sort.less(a[j], a[min])) {
          min = j;
        }
      }
      Sort.exch(a, i, min);
    }
  }
}
