package com.github.mdssjc.algorithms.chapter2.exercises21;

import com.github.mdssjc.algorithms.sort.Sort;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * InsertionSortEx4 Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class InsertionSortEx4 implements Sort {

  public void sort(final Comparable[] a) {
    int j;
    for (int i = 1; i < a.length; i++) {
      for (j = i; j > 0 && less(a[j], a[j - 1]); j--) {
        exch(a, j, j - 1);
      }
      StdOut.printf("%2d %2d  %s%n", i, j, Arrays.deepToString(a));
    }
    StdOut.printf("       %s%n", Arrays.deepToString(a));
  }
}
