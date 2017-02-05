package com.github.mdssjc.algorithms.sort.concrete;

import com.github.mdssjc.algorithms.sort.Sort;
import edu.princeton.cs.algs4.StdRandom;

/**
 * QuickSort (N log N / No Stable).
 *
 * @author Marcelo dos Santos
 *
 */
public class QuickSort implements Sort {

  private int partition(final Comparable[] a, final int lo, final int hi) {
    int i = lo;
    int j = hi + 1;
    final Comparable v = a[lo];

    while (true) {
      while (Sort.less(a[++i], v)) {
        if (i == hi) {
          break;
        }
      }
      while (Sort.less(v, a[--j])) {
        if (j == lo) {
          break;
        }
      }
      if (i >= j) {
        break;
      }
      Sort.exch(a, i, j);
    }
    Sort.exch(a, lo, j);
    return j;
  }

  private void sort(final Comparable[] a, final int lo, final int hi) {
    if (hi <= lo) {
      return;
    }

    final int j = partition(a, lo, hi);
    sort(a, lo, j - 1);
    sort(a, j + 1, hi);
  }

  @Override
  public void sort(final Comparable[] a) {
    StdRandom.shuffle(a);
    sort(a, 0, a.length - 1);
  }
}
