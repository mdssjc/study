package com.github.mdssjc.algorithms.chapter1.exercises14;

import edu.princeton.cs.algs4.StdOut;

/**
 * ThreeSumFixOverflow Class.
 * <p>
 * Count triples that sum to 0.
 *
 * @author Marcelo dos Santos
 *
 */
public class ThreeSumFixOverflow {

  public static int count(final int[] a) {
    final int n = a.length;
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
          final int sum = safeAdd(safeAdd(a[i], a[j]), a[k]);
          if (sum == 0) {
            StdOut.println("Value ok");
            cnt++;
          }
        }
      }
    }
    return cnt;
  }

  private static int safeAdd(final int left, final int right) {
    if ((right > 0)
        ? (left > (Integer.MAX_VALUE - right))
        : (left < (Integer.MIN_VALUE - right))) {
      // throw new ArithmeticException("Integer overflow");
      StdOut.println("Integer overflow");
    }
    return left + right;
  }
}
