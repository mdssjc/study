package com.github.mdssjc.algorithms.chapter1.section11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Binary Search algorithm.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = "largeW.txt", valueFile = true, input = "largeT.txt", inputFile = true)
@TestDrive(value = "tinyW.txt", valueFile = true, input = "tinyT.txt", inputFile = true)
public class BinarySearch {

  public static void main(final String[] args) {
    Executor.execute(BinarySearch.class, args);

    final int[] whitelist = new In(args[0]).readAllInts();

    Arrays.sort(whitelist);

    while (!StdIn.isEmpty()) {
      final int key = StdIn.readInt();
      if (rank(key, whitelist) == -1) {
        StdOut.println(key);
      }
    }
  }

  public static int rank(final int key, final int[] a) {
    int lo = 0;
    int hi = a.length - 1;

    while (lo <= hi) {
      final int mid = lo + (hi - lo) / 2;
      if (key < a[mid]) {
        hi = mid - 1;
      } else if (key > a[mid]) {
        lo = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }
}
