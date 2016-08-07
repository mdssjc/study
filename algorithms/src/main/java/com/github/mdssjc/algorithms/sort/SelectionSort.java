package com.github.mdssjc.algorithms.sort;

import com.github.mdssjc.algorithms.utils.SortHandles;

/**
 * SelectionSort.
 *
 * @author Marcelo dos Santos
 *
 */
public class SelectionSort implements SortHandles {

  public static void sort(final Comparable[] a) {
    final int N = a.length;

    for (int i = 0; i < N; i++) {
      int min = i;
      for (int j = i + 1; j < N; j++) {
        if (SortHandles.less(a[j], a[min])) {
          min = j;
        }
      }
      SortHandles.exch(a, i, min);
    }
  }
}
