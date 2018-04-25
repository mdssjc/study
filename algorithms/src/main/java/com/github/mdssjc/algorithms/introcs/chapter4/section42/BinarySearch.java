package com.github.mdssjc.algorithms.introcs.chapter4.section42;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.2.3 Binary search (sorted array).
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = "whitelist.txt", input = "emails.txt", inputFile = true)
public class BinarySearch {

  public static int search(final String key, final String[] a) {
    return search(key, a, 0, a.length);
  }

  public static int search(final String key, final String[] a,
                           final int lo, final int hi) {
    if (hi <= lo) {
      return -1;
    }
    final int mid = lo + (hi - lo) / 2;
    final int cmp = a[mid].compareTo(key);
    if (cmp > 0) {
      return search(key, a, lo, mid);
    } else if (cmp < 0) {
      return search(key, a, mid + 1, hi);
    } else {
      return mid;
    }
  }

  public static void main(final String[] args) {
    Executor.execute(BinarySearch.class, args);

    final In in = new In(args[0]);
    final String[] a = in.readAllStrings();
    while (!StdIn.isEmpty()) {
      final String key = StdIn.readString();
      if (search(key, a) < 0) {
        StdOut.println(key);
      }
    }
  }
}
