package com.github.mdssjc.algorithms.chapter1.section14;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Brute-force two sum.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = "1Kints.txt", valueFile = true)
@TestDrive(value = "2Kints.txt", valueFile = true)
@TestDrive(value = "4Kints.txt", valueFile = true)
@TestDrive(value = "8Kints.txt", valueFile = true)
@TestDrive(value = "16Kints.txt", valueFile = true)
@TestDrive(value = "32Kints.txt", valueFile = true)
@TestDrive(value = "1Mints.txt", valueFile = true)
public class TwoSum {

  public static void main(final String[] args) {
    Executor.execute(TwoSumFast.class, args);

    final int[] a = new In(args[0]).readAllInts();
    StdOut.println(count(a));
  }

  public static int count(final int[] a) {
    final int n = a.length;
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (a[i] + a[j] == 0) {
          count++;
        }
      }
    }
    return count;
  }
}
