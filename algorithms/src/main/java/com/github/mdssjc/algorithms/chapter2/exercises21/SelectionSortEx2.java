package com.github.mdssjc.algorithms.chapter2.exercises21;

import com.github.mdssjc.algorithms.sort.Sort;
import lombok.Getter;

/**
 * SelectionSortEx2 Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class SelectionSortEx2 implements Sort {

  @Getter
  private int max;
  @Getter
  private double average;

  public void sort(final Comparable[] a) {
    final int n = a.length;

    for (int i = 0; i < n; i++) {
      int min = i;
      for (int j = i + 1; j < n; j++) {
        if (less(a[j], a[min])) {
          min = j;
        }
      }
      exch(a, i, min);
      this.max++;
    }

    this.average = (double) (n) / this.max;
  }
}
