package com.github.mdssjc.algorithms.chapter1.exercises11;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Creative Exercício 29.
 * <p>
 * Equal keys.
 * 
 * @author Marcelo dos Santos
 *
 */
public class CEx29 {

  public static void main(final String[] args) {
    final int[] whitelist = IntStream.generate(() -> ThreadLocalRandom.current()
      .nextInt(5))
      .limit(10)
      .sorted()
      .toArray();

    StdOut.println(Arrays.toString(whitelist));
    while (!StdIn.isEmpty()) {
      final int key = StdIn.readInt();
      final int rank = rank(key, whitelist);
      final int count = count(key, whitelist);

      StdOut.println("Smaller than the key: " + rank);
      StdOut.println("Elements equal to the key: " + count);

      for (int i = rank; i < rank + count; i++) {
        StdOut.print(whitelist[i] + " ");
      }
      StdOut.println();
    }
  }

  public static int count(final int key, final int[] a) {
    return rank(key, a, e -> e == key);
  }

  public static int rank(final int key, final int[] a) {
    return rank(key, a, e -> e < key);
  }

  private static int rank(final int key, final int[] a,
      final IntPredicate predicate) {
    if (rank(key, a, 0, a.length - 1) != -1) {
      return (int) Arrays.stream(a)
        .filter(predicate)
        .count();
    }
    return 0;
  }

  private static int rank(final int key, final int[] a, final int lo,
      final int hi) {
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
}
