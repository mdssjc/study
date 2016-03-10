package com.github.mdssjc.algorithms.sort;

import com.github.mdssjc.algorithms.sort.utils.SortHandles;

public class MergeSort implements SortHandles {
  private Comparable[] aux;

  private static void merge(final Comparable[] a, final Comparable[] aux,
      final int lo, final int mid, final int hi) {
    // Precondition: a[lo..mid] sorted
    assert SortHandles.isSorted(a, lo, mid);
    // Precondition: a[mid+1..hi] sorted
    assert SortHandles.isSorted(a, mid + 1, hi);

    // Copy
    for (int k = 0; k < hi; k++) {
      aux[k] = a[k];
    }

    // Merge
    int i = lo;
    int j = mid + 1;

    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      } else if (j > hi) {
        a[k] = aux[i++];
      } else if (SortHandles.less(aux[j], aux[i])) {
        a[k] = aux[j++];
      } else {
        a[k] = aux[i++];
      }
    }

    // Postcondition: a[lo..mid] sorted
    assert SortHandles.isSorted(a, lo, mid);
  }

  private static void sort(final Comparable[] a, final Comparable[] aux,
      final int lo, final int hi) {
    // Base Case
    if (hi <= lo) {
      return;
    }

    final int mid = lo + (hi - lo) / 2;
    sort(a, aux, lo, mid);
    sort(a, aux, mid + 1, hi);
    merge(a, aux, lo, mid, hi);
  }

  public static void sort(final Comparable[] a) {
    Comparable[] aux = new Comparable[a.length];
    sort(a, aux, 0, a.length - 1);
  }
}
