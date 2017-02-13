package com.github.mdssjc.algorithms.chapter2.exercises22;

import com.github.mdssjc.algorithms.sort.Sort;

/**
 * MergeSortEx9 Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class MergeSortEx9 implements Sort {

  private final TYPE type;

  public MergeSortEx9(final TYPE type) {
    this.type = type;
  }

  private void merge(final Comparable[] a, final Comparable[] aux, final int lo, final int mid, final int hi) {
    // Precondition: a[lo..mid] sorted
    assert Sort.isSorted(a, lo, mid);
    // Precondition: a[mid+1..hi] sorted
    assert Sort.isSorted(a, mid + 1, hi);

    int i = lo;
    int j = mid + 1;

    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }

    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      } else if (j > hi) {
        a[k] = aux[i++];
      } else if (Sort.less(aux[j], aux[i])) {
        a[k] = aux[j++];
      } else {
        a[k] = aux[i++];
      }
    }

    // Postcondition: a[lo..mid] sorted
    assert Sort.isSorted(a, lo, mid);
  }

  private void sort(final Comparable[] a, final Comparable[] aux, final int lo, final int hi) {
    if (hi <= lo) {
      return;
    }
    final int mid = lo + (hi - lo) / 2;

    sort(a, aux, lo, mid);
    sort(a, aux, mid + 1, hi);

    merge(a, aux, lo, mid, hi);
  }

  // Top-down
  private void sortTopDown(final Comparable[] a, final Comparable[] aux) {
    sort(a, aux, 0, a.length - 1);
  }

  // Bottom-up
  private void sortBottomUp(final Comparable[] a, final Comparable[] aux) {
    final int n = a.length;

    for (int sz = 1; sz < n; sz = sz + sz) {
      for (int lo = 0; lo < n - sz; lo += sz + sz) {
        merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1));
      }
    }
  }

  @Override
  public void sort(final Comparable[] a) {
    final Comparable[] aux = new Comparable[a.length];

    if (TYPE.TOP_DOWN.equals(this.type)) {
      sortTopDown(a, aux);
    } else {
      sortBottomUp(a, aux);
    }
  }

  public enum TYPE {TOP_DOWN, BOTTOM_UP}
}
