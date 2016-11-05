package com.github.mdssjc.algorithms.chapter1.section14;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * ThreeSumFast Class.
 * <p>
 * Count triples that sum to 0.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( value = "1Kints.txt", valueFile = true )
@TestDrive( value = "2Kints.txt", valueFile = true )
@TestDrive( value = "4Kints.txt", valueFile = true )
@TestDrive( value = "8Kints.txt", valueFile = true )
public class ThreeSumFast {

  public static int count(final int[] a) {
    Arrays.sort(a);
    final int n = a.length;
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (BinarySearch.rank(-a[i]-a[j], a) > j) {
          cnt++;
        }
      }
    }
    return cnt;
  }

  public static void main(final String[] args) {
    Executor.execute(ThreeSumFast.class, args);

    final int[] a = In.readInts(args[0]);
    StdOut.println(count(a));
  }
}
