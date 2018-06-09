package com.github.mdssjc.algorithms.introcs.chapter4.section42;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.2.6 Mergesort.
 * <p>
 * Compilation:  javac Merge.java
 * Execution:    java Merge < input.txt
 * Data files:   http://www.cs.princeton.edu/introcs/43sort/8words.txt
 *               http://www.cs.princeton.edu/introcs/43sort/TomSawyer.txt
 * <p>
 * A bare-bones n log n implementation of mergesort.
 * <p>
 * Remarks
 * ---------
 * - number of comparisons is guaranteed to be at most n lg n
 * - sort is stable
 * <p>
 * % java Merge < 8words.txt
 * and but had him his the was you
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "8words.txt", inputFile = true)
public class Merge {

  private static void merge(final Comparable[] a, final Comparable[] aux, final int lo, final int mid, final int hi) {
    int i = lo, j = mid;
    for (var k = lo; k < hi; k++) {
      if (i == mid) {
        aux[k] = a[j++];
      } else if (j == hi) {
        aux[k] = a[i++];
      } else if (a[j].compareTo(a[i]) < 0) {
        aux[k] = a[j++];
      } else {
        aux[k] = a[i++];
      }
    }

    for (var k = lo; k < hi; k++) {
      a[k] = aux[k];
    }
  }

  public static void sort(final Comparable[] a, final Comparable[] aux, final int lo, final int hi) {
    if (hi - lo <= 1) {
      return;
    }

    final var mid = lo + (hi - lo) / 2;
    sort(a, aux, lo, mid);
    sort(a, aux, mid, hi);

    merge(a, aux, lo, mid, hi);
  }

  public static void sort(final Comparable[] a) {
    final var n = a.length;
    final var aux = new Comparable[n];
    sort(a, aux, 0, n);
  }

  public static void sort(final Comparable[] a, final int lo, final int hi) {
    final var n = hi - lo + 1;
    final var aux = new Comparable[n];
    sort(a, aux, lo, hi);
  }

  private static boolean isSorted(final Comparable[] a) {
    for (var i = 1; i < a.length; i++) {
      if (a[i].compareTo(a[i - 1]) < 0) {
        return false;
      }
    }
    return true;
  }

  public static void show(final Comparable[] a) {
    for (var i = 0; i < a.length; i++) {
      StdOut.println(a[i]);
    }
  }

  public static void main(final String[] args) {
    Executor.execute(Merge.class, args);

    final var a = StdIn.readAllStrings();
    Merge.sort(a);
    assert isSorted(a);
    for (var i = 0; i < a.length; i++) {
      StdOut.print(a[i] + " ");
    }
    StdOut.println();
  }
}
