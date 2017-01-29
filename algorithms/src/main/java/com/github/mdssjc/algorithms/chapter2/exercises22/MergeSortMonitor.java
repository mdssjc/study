package com.github.mdssjc.algorithms.chapter2.exercises22;

import com.github.mdssjc.algorithms.sort.Sort;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * MergeSortMonitor Class.
 *
 * @author Marcelo dos Santos
 */
public class MergeSortMonitor implements Sort {

  private final TYPE type;
  private final MONITOR monitor;
  private Comparable[] aux;
  private boolean m1FirstTime;

  public MergeSortMonitor(final TYPE type, final MONITOR monitor) {
    this.type = type;
    this.monitor = monitor;
    this.m1FirstTime = true;
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
      monitor2(a, lo, hi, i, j, k);
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
    monitor1(a, lo, hi);
  }

  // Top-down
  private void sortTopDown(final Comparable[] a) {
    this.aux = new Comparable[a.length];
    sort(a, 0, a.length - 1);
  }

  // Bottom-up
  private void sortBottomUp(final Comparable[] a) {
    final int n = a.length;
    this.aux = new Comparable[n];

    for (int sz = 1; sz < n; sz = sz + sz) {
      for (int lo = 0; lo < n - sz; lo += sz + sz) {
        merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1));
      }
    }
  }

  @Override
  public void sort(final Comparable[] a) {
    if (MergeSortMonitor.TYPE.TOP_DOWN.equals(this.type)) {
      sortTopDown(a);
    }
    sortBottomUp(a);
  }

  private void monitor1(final Comparable[] a, final int lo, final int hi) {
    if (this.monitor == MONITOR.M2) {
      StdOut.printf("%2d %2d  %s%n", lo, hi, Arrays.deepToString(a));
    }
  }

  private void monitor2(final Comparable[] a, final int lo, final int hi, final int i, final int j, final int k) {
    if (this.monitor == MONITOR.M1 &&
        lo == 0 && hi == a.length - 1 &&
        this.m1FirstTime) {
      final Comparable[] result = Arrays.copyOf(a, k + 1);
      StdOut.printf("%2d %2d %2d  %s%n", k, i, j, Arrays.deepToString(result));
      if (k == hi) {
        this.m1FirstTime = false;
        StdOut.printf("          %s%n", Arrays.deepToString(a));
      }
    }
  }

  public enum TYPE {TOP_DOWN, BOTTOM_UP}

  public enum MONITOR {M1, M2}
}
