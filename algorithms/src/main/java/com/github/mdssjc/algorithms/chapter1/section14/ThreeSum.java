package com.github.mdssjc.algorithms.chapter1.section14;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * ThreeSum Class.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( value = "1Kints.txt", valueFile = true )
@TestDrive( value = "2Kints.txt", valueFile = true )
@TestDrive( value = "4Kints.txt", valueFile = true )
@TestDrive( value = "8Kints.txt", valueFile = true )
public class ThreeSum {

  public static int count(final int[] a) {
    // Count triples that sum to 0.
    final int n = a.length;
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
          if (a[i] + a[j] + a[k] == 0) {
            cnt++;
          }
        }
      }
    }
    return cnt;
  }

  public static void main(final String[] args) {
    Executor.execute(ThreeSum.class, args);

    final int[] a = In.readInts(args[0]);
    StdOut.println(count(a));
  }
}
