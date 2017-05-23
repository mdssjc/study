package com.github.mdssjc.algorithms.search.concrete;

import com.github.mdssjc.algorithms.search.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Implementação de Binary Search em Recursão.
 *
 * @author Marcelo dos Santos
 *
 */
public class BinarySearchRecursive implements BinarySearch {

  @Override
  public int indexOf(final int[] a, final int key) {
    return indexOf(a, key, 0, a.length - 1);
  }

  private int indexOf(final int[] a, final int key, final int lo, final int hi) {
    if (lo > hi) {
      return -1;
    }

    final int mid = lo + (hi - lo) / 2;
    if (key < a[mid]) {
      return indexOf(a, key, lo, mid - 1);
    }
    if (key > a[mid]) {
      return indexOf(a, key, mid + 1, hi);
    }
    return mid;
  }

  public static void main(final String[] args) {
    final BinarySearch bs = new BinarySearchRecursive();
    final int[] whitelist = new In(args[0]).readAllInts();

    Arrays.sort(whitelist);

    while (!StdIn.isEmpty()) {
      final int key = StdIn.readInt();
      if (bs.indexOf(whitelist, key) == -1) {
        StdOut.println(key);
      }
    }
  }
}
