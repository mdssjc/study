package com.github.mdssjc.algorithms.search.concrete;

import com.github.mdssjc.algorithms.search.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Implementação de Binary Search em Iteração.
 *
 * @author Marcelo dos Santos
 *
 */
public class BinarySearchIterative implements BinarySearch {

  @Override
  public int indexOf(final int[] a, final int key) {
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

  public static void main(final String[] args) {
    final BinarySearch bs = new BinarySearchIterative();
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
