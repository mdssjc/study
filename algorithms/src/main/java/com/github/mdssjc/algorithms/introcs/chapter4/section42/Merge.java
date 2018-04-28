package com.github.mdssjc.algorithms.introcs.chapter4.section42;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.2.6 Mergesort.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "8words.txt", inputFile = true)
@TestDrive(input = "TomSawyer.txt", inputFile = true)
public class Merge {

  public static void sort(final Comparable[] a) {
    final Comparable[] aux = new Comparable[a.length];
    sort(a, aux, 0, a.length);
  }

  private static void sort(final Comparable[] a, final Comparable[] aux,
                           final int lo, final int hi) {
    if (hi - lo <= 1) {
      return;
    }
    final int mid = lo + (hi - lo) / 2;
    sort(a, aux, lo, mid);
    sort(a, aux, mid, hi);
    int i = lo, j = mid;
    for (int k = lo; k < hi; k++) {
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
    for (int k = lo; k < hi; k++) {
      a[k] = aux[k];
    }
  }

  public static void sort(final Comparable[] a, final int lo, final int hi) {
    final int n = hi - lo + 1;
    final Comparable[] aux = new Comparable[n];
    sort(a, aux, lo, hi);
  }

  public static void main(final String[] args) {
    Executor.execute(Merge.class, args);

    final String[] a = StdIn.readAllStrings();
    sort(a);
    for (int i = 0; i < a.length; i++) {
      StdOut.print(a[i] + " ");
    }
    StdOut.println();
  }
}
