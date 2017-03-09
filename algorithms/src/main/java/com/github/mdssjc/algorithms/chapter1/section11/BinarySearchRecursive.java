package com.github.mdssjc.algorithms.chapter1.section11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Binary Search Recursive algorithm.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = "largeW.txt", valueFile = true, input = "largeT.txt", inputFile = true)
public class BinarySearchRecursive {

  public static void main(final String[] args) {
    Executor.execute(BinarySearchRecursive.class, args);

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
    return rank(key, a, 0, a.length - 1);
  }

  private static int rank(final int key, final int[] a, final int lo, final int hi) {
    if (lo > hi) {
      return -1;
    }

    final int mid = lo + (hi - lo) / 2;
    if (key < a[mid]) {
      return rank(key, a, lo, mid - 1);
    }
    if (key > a[mid]) {
      return rank(key, a, mid + 1, hi);
    }
    return mid;
  }
}
