package com.github.mdssjc.algorithms.sort;

import com.github.mdssjc.algorithms.sort.utils.SortHandles;

public class ShellSort implements SortHandles {

  public static void sort(final Comparable[] a) {
    final int N = a.length;
    int h = 1;

    while (h < N / 3) {
      h = 3 * h + 1;
    }

    while (h >= 1) {
      for (int i = h; i < N; i++) {
        for (int j = i; j >= h && SortHandles.less(a[j], a[j - h]); j -= h) {
          SortHandles.exch(a, j, j - h);
        }
      }
      h = h / 3;
    }
  }
}
