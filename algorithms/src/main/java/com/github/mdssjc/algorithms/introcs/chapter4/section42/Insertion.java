package com.github.mdssjc.algorithms.introcs.chapter4.section42;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.2.4 Insertion sort.
 * <p>
 * Compilation:  javac Insertion.java
 * Execution:    java Insertion < input.txt
 * Data files:   http://www.cs.princeton.edu/introcs/43sort/8words.txt
 *               http://www.cs.princeton.edu/introcs/43sort/TomSawyer.txt
 * <p>
 * Reads in strings from standard input and prints them in sorted order.
 * Uses insertion sort.
 * <p>
 * % java Insertion < 8words.txt
 * and but had him his the was you
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "8words.txt", inputFile = true)
public class Insertion {

  public static void sort(final Comparable[] a) {
    final var n = a.length;
    for (var i = 1; i < n; i++) {
      for (var j = i; j > 0; j--) {
        if (a[j - 1].compareTo(a[j]) > 0) {
          exch(a, j - 1, j);
        } else {
          break;
        }
      }
    }
  }

  private static void exch(final Comparable[] a, final int i, final int j) {
    final var swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }

  public static void main(final String[] args) {
    Executor.execute(Insertion.class, args);

    final var a = StdIn.readAllStrings();
    sort(a);
    for (var i = 0; i < a.length; i++) {
      StdOut.print(a[i] + " ");
    }
    StdOut.println();
  }
}
