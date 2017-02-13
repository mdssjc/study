package com.github.mdssjc.algorithms.sort.concrete;

import com.github.mdssjc.algorithms.sort.Sort;

/**
 * Merge Sort (N log N / Stable).
 *
 * @author Marcelo dos Santos
 *
 */
public class MergeSort implements Sort {

  private final TYPE type;
  private Comparable[] aux;

  public MergeSort(final TYPE type) {
    this.type = type;
  }

  private void merge(final Comparable[] a, final int lo, final int mid, final int hi) {
    // Precondition: a[lo..mid] sorted
    assert Sort.isSorted(a, lo, mid);
    // Precondition: a[mid+1..hi] sorted
    assert Sort.isSorted(a, mid + 1, hi);

    int i = lo;
    int j = mid + 1;

    for (int k = lo; k <= hi; k++) {
      this.aux[k] = a[k];
    }

    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        a[k] = this.aux[j++];
      } else if (j > hi) {
        a[k] = this.aux[i++];
      } else if (Sort.less(this.aux[j], this.aux[i])) {
        a[k] = this.aux[j++];
      } else {
        a[k] = this.aux[i++];
      }
    }

    // Postcondition: a[lo..mid] sorted
    assert Sort.isSorted(a, lo, mid);
  }

  private void sort(final Comparable[] a, final int lo, final int hi) {
    if (hi <= lo) {
      return;
    }
    final int mid = lo + (hi - lo) / 2;

    sort(a, lo, mid);
    sort(a, mid + 1, hi);

    merge(a, lo, mid, hi);
  }

  // Top-down
  private void sortTopDown(final Comparable[] a) {
    sort(a, 0, a.length - 1);
  }

  // Bottom-up
  private void sortBottomUp(final Comparable[] a) {
    final int n = a.length;

    for (int sz = 1; sz < n; sz = sz + sz) {
      for (int lo = 0; lo < n - sz; lo += sz + sz) {
        merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1));
      }
    }
  }

  @Override
  public void sort(final Comparable[] a) {
    this.aux = new Comparable[a.length];

    if (TYPE.TOP_DOWN.equals(this.type)) {
      sortTopDown(a);
    } else {
      sortBottomUp(a);
    }
  }

  public enum TYPE {TOP_DOWN, BOTTOM_UP}
}
