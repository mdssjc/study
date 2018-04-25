package com.github.mdssjc.algorithms.introcs.chapter4.section42;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.2.4 Insertion sort.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "8words.txt", inputFile = true)
@TestDrive(input = "TomSawyer.txt", inputFile = true)
public class Insertion {

  public static void sort(final Comparable[] a) {
    final int n = a.length;
    for (int i = 1; i < n; i++) {
      for (int j = i; j > 0; j--) {
        if (a[j].compareTo(a[j - 1]) < 0) {
          exchange(a, j - 1, j);
        } else {
          break;
        }
      }
    }
  }

  public static void exchange(final Comparable[] a, final int i, final int j) {
    final Comparable temp = a[j];
    a[j] = a[i];
    a[i] = temp;
  }

  public static void main(final String[] args) {
    Executor.execute(Insertion.class, args);

    final String[] a = StdIn.readAllStrings();
    sort(a);
    for (int i = 0; i < a.length; i++) {
      StdOut.print(a[i] + " ");
    }
    StdOut.println();
  }
}
