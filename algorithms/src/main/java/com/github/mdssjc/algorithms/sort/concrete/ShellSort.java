package com.github.mdssjc.algorithms.sort.concrete;

import com.github.mdssjc.algorithms.sort.Sort;

/**
 * ShellSort.
 *
 * @author Marcelo dos Santos
 *
 */
public class ShellSort implements Sort {

  public  void sort(final Comparable[] a) {
    final int n = a.length;
    int h = 1;

    while (h < n / 3) {
      h = 3 * h + 1;
    }

    while (h >= 1) {
      for (int i = h; i < n; i++) {
        for (int j = i; j >= h && Sort.less(a[j], a[j - h]); j -= h) {
          Sort.exch(a, j, j - h);
        }
      }
      h = h / 3;
    }
  }
}
