package com.github.mdssjc.algorithms.chapter2.exercises21;

import com.github.mdssjc.algorithms.sort.Sort;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * SelectionSortEx1 Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class SelectionSortEx1 implements Sort {

  public void sort(final Comparable[] a) {
    final int n = a.length;

    for (int i = 0; i < n; i++) {
      int min = i;
      for (int j = i + 1; j < n; j++) {
        if (less(a[j], a[min])) {
          min = j;
        }
      }

      StdOut.printf("%2d %3d  %s%n", i, min, Arrays.deepToString(a));
      exch(a, i, min);
    }

    StdOut.printf("        %s%n", Arrays.deepToString(a));
  }
}
