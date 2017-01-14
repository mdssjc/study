package com.github.mdssjc.algorithms.search.concrete;

import com.github.mdssjc.algorithms.search.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Implementação Recursiva do Binary Search.
 *
 * @author Marcelo dos Santos
 *
 */
public class BinarySearchRecursive implements BinarySearch {

  @Override
  public int rank(final int key, final int[] a) {
    return rank(key, a, 0, a.length - 1);
  }

  private int rank(final int key, final int[] a, final int lo, final int hi) {
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
    final int[] whitelist = In.readInts(args[0]);

    Arrays.sort(whitelist);
    final BinarySearch bs = new BinarySearchRecursive();

    while (!StdIn.isEmpty()) {
      final int key = StdIn.readInt();
      if (bs.rank(key, whitelist) == -1) {
        StdOut.println(key);
      }
    }
  }
}
