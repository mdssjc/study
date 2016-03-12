package com.github.mdssjc.algorithms.sort;

import com.github.mdssjc.algorithms.sort.utils.SortHandles;

import edu.princeton.cs.algs4.StdRandom;

/**
 * QuickSort (N log N / No Stable).
 *
 * @author Marcelo dos Santos
 *
 */
public class QuickSort implements SortHandles {

  private static final int CUTOFF = 10;

  private static int partition(final Comparable[] a, final int lo,
      final int hi) {
    int i = lo;
    int j = hi + 1;

    while (true) {
      while (SortHandles.less(a[++i], a[lo])) {
        if (i == hi) {
          break;
        }
      }

      while (SortHandles.less(a[lo], a[--j])) {
        if (j == lo) {
          break;
        }
      }

      if (i >= j) {
        break;
      }

      SortHandles.exch(a, i, j);
    }

    SortHandles.exch(a, lo, j);
    return j;
  }

  private static void sort(final Comparable[] a, final int lo, final int hi) {
    // IMPROVEMENTS
    if (hi <= lo + CUTOFF - 1) {
      InsertionSort.sort(a);
      return;
    }

    // int m = medianOf3(a, lo, lo + (hi - lo) / 2, hi);
    // SortHandles.exch(a, lo, m);
    // --

    // if (hi <= lo) {
    // return;
    // }

    final int j = partition(a, lo, hi);
    sort(a, lo, j - 1);
    sort(a, j + 1, hi);
  }

  public static void sort(final Comparable[] a) {
    StdRandom.shuffle(a);
    sort(a, 0, a.length - 1);
  }
}
