package com.github.mdssjc.algorithms.chapter1.section14;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * TwoSumFast Class.
 * <p>
 * Count pairs that sum to 0.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( value = "1Mints.txt", valueFile = true )
public class TwoSumFast {

  public static int count(final int[] a) {
    // Count pairs that sum to 0.
    Arrays.sort(a);
    final int n = a.length;
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      if (BinarySearch.rank(-a[i], a) > i) {
        cnt++;
      }
    }
    return cnt;
  }

  public static void main(final String[] args) {
    Executor.execute(TwoSumFast.class, args);

    final int[] a = In.readInts(args[0]);
    StdOut.println(count(a));
  }
}
