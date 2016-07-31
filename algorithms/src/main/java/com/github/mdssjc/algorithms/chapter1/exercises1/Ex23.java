package com.github.mdssjc.algorithms.chapter1.exercises1;

import java.util.stream.IntStream;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 23.
 * 
 * @author Marcelo dos Santos
 *
 */
public class Ex23 {

  public static void main(final String[] args) {
    final int[] whitelist = IntStream.range(30, 60)
      .sorted()
      .toArray();

    while (!StdIn.isEmpty()) {
      final int key = StdIn.readInt();
      if (rank(key, whitelist) == -1) {
        StdOut.print("- ");
      } else {
        StdOut.print("+ ");
      }
      StdOut.println(key);
    }
  }

  private static int rank(final int key, final int[] a) {
    return rank(key, a, 0, a.length - 1, 0);
  }

  private static int rank(final int key, final int[] a, final int lo,
      final int hi, final int depth) {
    traces(lo, hi, depth);

    if (lo > hi) {
      return -1;
    }
    final int mid = lo + (hi - lo) / 2;
    if (key < a[mid]) {
      return rank(key, a, lo, mid - 1, depth + 1);
    } else if (key > a[mid]) {
      return rank(key, a, mid + 1, hi, depth + 1);
    } else {
      return mid;
    }
  }

  private static void traces(final int lo, final int hi, final int depth) {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < depth; i++) {
      sb.append("  ");
    }
    StdOut.printf("%s LO: %d, HI: %d%n", sb, lo, hi);
  }
}
