package com.github.mdssjc.algorithms.sort;

import com.github.mdssjc.algorithms.sort.utils.SortHandles;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort implements SortHandles {

  private static int partition(final Comparable[] a, final int lo,
      final int hi) {
    int i = lo;
    int j = hi + 1;

    while (true) {
      // find item on left to swap
      while (SortHandles.less(a[++i], a[lo])) {
        if (i == hi) {
          break;
        }
      }

      // find item on right to swap
      while (SortHandles.less(a[lo], a[--j])) {
        if (j == lo) {
          break;
        }
      }

      // check if pointers cross
      if (i >= j) {
        break;
      }

      // swap
      SortHandles.exch(a, i, j);
    }

    // swap with partitioning item
    SortHandles.exch(a, lo, j);

    // return index of item now known to be in place
    return j;
  }

  private static void sort(final Comparable[] a, final int lo, final int hi) {
    if (hi <= lo) {
      return;
    }

    final int j = partition(a, lo, hi);
    sort(a, lo, j - 1);
    sort(a, j + 1, hi);
  }

  public static void sort(final Comparable[] a) {
    StdRandom.shuffle(a);
    sort(a, 0, a.length - 1);
  }
}
