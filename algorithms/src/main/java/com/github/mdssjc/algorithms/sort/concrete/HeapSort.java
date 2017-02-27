package com.github.mdssjc.algorithms.sort.concrete;

import com.github.mdssjc.algorithms.sort.Sort;

/**
 * Heap Sort.
 *
 * @author Marcelo dos Santos
 *
 */
public class HeapSort implements Sort {

  @Override
  public void sort(final Comparable[] a) {
    int n = a.length;
    for (int k = n / 2; k >= 1; k--) {
      sink(a, k, n);
    }
    while (n > 1) {
      exch(a, 1, n--);
      sink(a, 1, n);
    }
  }

  private void sink(final Comparable[] a, int k, final int n) {
    while (2 * k <= n) {
      int j = 2 * k;
      if (j < n && less(a, j, j + 1)) {
        j++;
      }
      if (!less(a, k, j)) {
        break;
      }
      exch(a, k, j);
      k = j;
    }
  }

  public boolean less(final Comparable[] a, final int i, final int j) {
    return a[i - 1].compareTo(a[j - 1]) < 0;
  }

  public void exch(final Comparable[] a, final int i, final int j) {
    final Comparable swap = a[i - 1];
    a[i - 1] = a[j - 1];
    a[j - 1] = swap;
  }
}
