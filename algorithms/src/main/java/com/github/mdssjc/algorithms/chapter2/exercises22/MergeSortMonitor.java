package com.github.mdssjc.algorithms.chapter2.exercises22;

import com.github.mdssjc.algorithms.sort.Sort;
import com.github.mdssjc.algorithms.utils.Monitor;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * MergeSortMonitor Class.
 *
 * TODO: usar um vetor para contar os acessos e compares de cada k.
 *
 * @author Marcelo dos Santos
 *
 */
public class MergeSortMonitor implements Sort {

  private Comparable[] aux;
  private final TYPE type;
  private final Monitor monitor;
  private int countAccesses;
  private int countCompares;

  public MergeSortMonitor(final TYPE type, final Monitor monitor) {
    this.monitor = monitor;
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
      this.countAccesses += 2;
    }

    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        a[k] = this.aux[j++];
        this.countAccesses += 2;
      } else if (j > hi) {
        a[k] = this.aux[i++];
        this.countAccesses += 2;
      } else if (Sort.less(this.aux[j], this.aux[i])) {
        a[k] = this.aux[j++];
        this.countAccesses += 4;
        this.countCompares++;
      } else {
        a[k] = this.aux[i++];
        this.countAccesses += (2 + 2);
      }

      if (this.monitor.test("m1", lo == 0 && hi == a.length - 1)) {
        final Comparable[] result = Arrays.copyOf(a, a.length);
        Arrays.fill(result, k + 1, a.length, " ");
        this.monitor.print("m1", result, "", k, i, j);
      }

      if (this.monitor.test("m4", lo == 0 && hi == a.length - 1)) {
        final double calculate = 6 * (k + 1) * (Math.log(k + 1) / Math.log(2));
        StdOut.printf("k(%d) %d / %.2f -> %.2f times %n",
                      k + 1, this.countAccesses, calculate, calculate / this.countAccesses);
      }

      if (this.monitor.test("m5")) {
        StdOut.printf("k(%d) %d compares%n", k, this.countCompares);
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

    final boolean predicate = lo == 0 && hi == a.length - 1;
    this.monitor.print("m1", predicate, a, "input");
    this.monitor.print("m1", predicate, a, "copy");
    merge(a, lo, mid, hi);
    this.monitor.print("m1", predicate, a, "merged result");
    this.monitor.print("m2", a, String.format("merge(a, %d, %d, %d)", lo, mid, hi), lo, hi);
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
      this.monitor.print("m3", a, String.format("sz=%d", sz));
      for (int lo = 0; lo < n - sz; lo += sz + sz) {
        merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1));
        this.monitor.print("m3", a, String.format("merge(a, %d, %d, %d)", lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1)));
      }
    }
  }

  @Override
  public void sort(final Comparable[] a) {
    if (MergeSortMonitor.TYPE.TOP_DOWN.equals(this.type)) {
      sortTopDown(a);
    } else {
      sortBottomUp(a);
    }
  }

  public enum TYPE {TOP_DOWN, BOTTOM_UP}
}
