package com.github.mdssjc.algorithms.chapter1.section11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * BinarySearch Class.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( value = "largeW.txt", valueFile = true, input = "largeT.txt", inputFile = true )
@TestDrive( value = "tinyW.txt", valueFile = true, input = "tinyT.txt", inputFile = true )
public class BinarySearch {

  public static int rank(final int key, final int[] a) {
    // Array must be sorted.
    int lo = 0;
    int hi = a.length - 1;

    while (lo <= hi) {
      // Key is in a[lo..hi] or not present.
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

  public static void main(final String[] args) {
    Executor.execute(BinarySearch.class, args);

    final int[] whitelist = In.readInts(args[0]);

    Arrays.sort(whitelist);

    while (!StdIn.isEmpty()) {
      // Read key, print if not in whitelist.
      final int key = StdIn.readInt();
      if (rank(key, whitelist) == -1) {
        StdOut.println(key);
      }
    }
  }
}
