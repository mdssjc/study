package com.github.mdssjc.algorithms.chapter2.exercises23;

import com.github.mdssjc.algorithms.sort.Sort;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * QuickSortMonitor Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class QuickSortMonitor implements Sort {

  private int partition(final Comparable[] a, final int lo, final int hi) {
    int i = lo;
    int j = hi + 1;
    final Comparable v = a[lo];

    StdOut.printf("%23s%2d %2d %s%n", "initial values: ", i, j, Arrays.deepToString(a));
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
      StdOut.printf("%23s%2d %2d %s%n","scan left, scan right: ", i, j, Arrays.deepToString(a));
      Sort.exch(a, i, j);
      StdOut.printf("%23s%2d %2d %s%n","exchange: ", i, j, Arrays.deepToString(a));
    }
    Sort.exch(a, lo, j);
    StdOut.printf("%23s%2d %2d %s%n","final exchange: ", i, j, Arrays.deepToString(a));
    return j;
  }

  private void sort(final Comparable[] a, final int lo, final int hi) {
    if (hi <= lo) {
      return;
    }

    final int j = partition(a, lo, hi);
    StdOut.printf("%26s%2d %s%n","result:    ", j, Arrays.deepToString(a));
    sort(a, lo, j - 1);
    sort(a, j + 1, hi);
  }

  @Override
  public void sort(final Comparable[] a) {
    StdRandom.shuffle(a);
    sort(a, 0, a.length - 1);
  }
}
