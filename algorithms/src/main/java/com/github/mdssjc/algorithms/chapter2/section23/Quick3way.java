package com.github.mdssjc.algorithms.chapter2.section23;

import com.github.mdssjc.algorithms.sort.Sort;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Quick3way Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Quick3way implements Sort {

  private void sort(final Comparable[] a, final int lo, final int hi) {
    if (hi <= lo) {
      return;
    }
    int lt = lo;
    int i = lo + 1;
    int gt = hi;
    final Comparable v = a[lo];
    while (i <= gt) {
      final int cmp = a[i].compareTo(v);
      if (cmp < 0) {
        exch(a, lt++, i++);
      } else if (cmp > 0) {
        exch(a, i, gt--);
      } else {
        i++;
      }
    }
    sort(a, lo, lt - 1);
    sort(a, gt + 1, hi);
  }

  @Override
  public void sort(final Comparable[] a) {
    StdRandom.shuffle(a);
    sort(a, 0, a.length - 1);
  }
}
