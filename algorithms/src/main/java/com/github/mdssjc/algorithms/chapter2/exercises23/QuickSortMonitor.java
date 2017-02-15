package com.github.mdssjc.algorithms.chapter2.exercises23;

import com.github.mdssjc.algorithms.sort.Sort;
import com.github.mdssjc.algorithms.utils.Monitor;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * QuickSortMonitor Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class QuickSortMonitor implements Sort {

  private final Monitor monitor;
  private int cntLargestItem;
  private int cntCompares;

  public QuickSortMonitor(final Monitor monitor) {
    this.monitor = monitor;
  }

  private int partition(final Comparable[] a, final int lo, final int hi) {
    int i = lo;
    int j = hi + 1;
    final Comparable v = a[lo];

    this.monitor.print("m1", a, "initial values", i, j);

    while (true) {
      while (Sort.less(a[++i], v)) {
        if (i == hi) {
          this.cntLargestItem++;
          this.cntCompares++;
          break;
        }
      }
      while (Sort.less(v, a[--j])) {
        if (j == lo) {
          this.cntCompares++;
          break;
        }
      }
      if (i >= j) {
        this.cntCompares++;
        break;
      }

      this.monitor.print("m1", a, "scan left, scan right", i, j);
      Sort.exch(a, i, j);
      this.monitor.print("m1", a, "exchange", i, j);
    }
    Sort.exch(a, lo, j);
    this.monitor.print("m1", a, "final exchange", i, j);
    return j;
  }

  private void sort(final Comparable[] a, final int lo, final int hi) {
    this.monitor.print("m2", lo == hi, a, "no partition (size 1)", lo, 0, hi);
    if (hi <= lo) {
      return;
    }

    final int j = partition(a, lo, hi);
    this.monitor.print("m1", a, "result", j);
    this.monitor.print("m2", a, lo, j, hi);
    sort(a, lo, j - 1);
    sort(a, j + 1, hi);
  }

  @Override
  public void sort(final Comparable[] a) {
    this.monitor.print("m2", a, "initial values");
    if (!this.monitor.test("m4")) {
      StdRandom.shuffle(a);
    }
    this.monitor.print("m2", a, "random shuffle");
    sort(a, 0, a.length - 1);
    this.monitor.print("m2", a, "result");
    if (this.monitor.test("m3")) {
      StdOut.printf("N=%d, maximum of exchange: %d%n", a.length, this.cntLargestItem);
    }
    if (this.monitor.test("m4")) {
      StdOut.printf("Compares: %d%n", this.cntCompares);
    }
  }
}
