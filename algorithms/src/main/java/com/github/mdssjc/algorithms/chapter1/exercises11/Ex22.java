package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

import java.util.stream.IntStream;

/**
 * Exercício 22.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex22 {

  public static void main(final String[] args) {
    Executor.execute(Ex22.class, args);

    final int[] xs = IntStream.range(0, 1000)
                              .sorted()
                              .toArray();
    BinarySearchRecursiveTraces.rank(5, xs);
  }
}

class BinarySearchRecursiveTraces {

  public static int rank(final int key, final int[] a) {
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
