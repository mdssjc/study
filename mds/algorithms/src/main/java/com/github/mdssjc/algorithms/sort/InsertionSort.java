package com.github.mdssjc.algorithms.sort;

import com.github.mdssjc.algorithms.sort.utils.SortHandles;

public class InsertionSort implements SortHandles {

  public static void sort(final Comparable[] a) {
    final int N = a.length;

    for (int i = 0; i < N; i++) {
      for (int j = i; j > 0; j--) {
        if (SortHandles.less(a[j],
                             a[j - 1])) {
          SortHandles.exch(a,
                           j,
                           j - 1);
        } else {
          break;
        }
      }
    }
  }
}
