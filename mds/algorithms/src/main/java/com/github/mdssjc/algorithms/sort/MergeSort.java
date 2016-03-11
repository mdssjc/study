package com.github.mdssjc.algorithms.sort;

import com.github.mdssjc.algorithms.sort.utils.SortHandles;

import edu.princeton.cs.algs4.Insertion;

public class MergeSort implements SortHandles {

  private final static int    CUTOFF = 7;
  private static Comparable[] aux;

  private static void merge(final Comparable[] a, final Comparable[] aux,
      final int lo, final int mid, final int hi) {
    // Precondition: a[lo..mid] sorted
    assert SortHandles.isSorted(a,
                                lo,
                                mid);
    // Precondition: a[mid+1..hi] sorted
    assert SortHandles.isSorted(a,
                                mid + 1,
                                hi);

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
      } else if (SortHandles.less(aux[j],
                                  aux[i])) {
        a[k] = aux[j++];
      } else {
        a[k] = aux[i++];
      }
    }

    // Postcondition: a[lo..mid] sorted
    assert SortHandles.isSorted(a,
                                lo,
                                mid);
  }

  private static void sort(final Comparable[] a, final Comparable[] aux,
      final int lo, final int hi) {
    // Base Case
    // Use insertion sort for small subarrays
    if (hi <= lo + CUTOFF - 1) {
      Insertion.sort(a,
                     lo,
                     hi);
      return;
    }

    final int mid = lo + (hi - lo) / 2;
    sort(a,
         aux,
         lo,
         mid);
    sort(a,
         aux,
         mid + 1,
         hi);
    // Stop if already sorted
    if (!SortHandles.less(a[mid + 1],
                          a[mid])) {
      return;
    }
    merge(a,
          aux,
          lo,
          mid,
          hi);
  }

  // Top-down
  public static void sort(final Comparable[] a) {
    aux = new Comparable[a.length];
    sort(a,
         aux,
         0,
         a.length - 1);
  }

  // Bottom-up
  public static void sortBU(final Comparable[] a) {
    int N = a.length;
    aux = new Comparable[N];
    for (int sz = 1; sz < N; sz = sz + sz) {
      for (int lo = 0; lo < N - sz; lo += sz + sz) {
        merge(a,
              aux,
              lo,
              lo + sz - 1,
              Math.min(lo + sz + sz - 1,
                       N - 1));
      }
    }
  }
}
