package com.github.mdssjc.algorithms.chapter1.section11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * BinarySearchRecursive Class.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( value = "largeW.txt", valueFile = true, input = "largeT.txt", inputFile = true )
public class BinarySearchRecursive {

  public static int rank(final int key, final int[] a) {
    return rank(key, a, 0, a.length - 1);
  }

  private static int rank(final int key, final int[] a, final int lo, final int hi) {
    // Index of key in a[], if present, is not smaller than lo and not larger
    // than hi.
    if (lo > hi) {
      return -1;
    }
    final int mid = lo + (hi - lo) / 2;
    if (key < a[mid]) {
      return rank(key, a, lo, mid - 1);
    } else if (key > a[mid]) {
      return rank(key, a, mid + 1, hi);
    } else {
      return mid;
    }
  }

  public static void main(final String[] args) {
    Executor.execute(BinarySearchRecursive.class, args);

    final int[] whitelist = In.readInts(args[0]);

    Arrays.sort(whitelist);

    while (!StdIn.isEmpty()) {
      final int key = StdIn.readInt();
      if (rank(key, whitelist) == -1) {
        StdOut.println(key);
      }
    }
  }
}
