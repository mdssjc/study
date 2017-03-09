package com.github.mdssjc.algorithms.chapter1.section12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Knuth shuffle.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "cards.txt", inputFile = true)
@TestDrive(input = "cardsUnicode.txt", inputFile = true)
public class Knuth {

  public static void main(final String[] args) {
    Executor.execute(Knuth.class, args);

    final String[] a = StdIn.readAllStrings();
    Knuth.shuffle(a);

    for (String element : a) {
      StdOut.println(element);
    }
  }

  public static <T> void shuffle(final T[] a) {
    final int n = a.length;

    for (int i = 0; i < n; i++) {
      final int r = (int) (Math.random() * (i + 1));
      final T swap = a[r];
      a[r] = a[i];
      a[i] = swap;
    }
  }

  public static <T> void shuffleAlternate(final T[] a) {
    final int n = a.length;

    for (int i = 0; i < n; i++) {
      final int r = i + (int) (Math.random() * (n - i));
      final T swap = a[r];
      a[r] = a[i];
      a[i] = swap;
    }
  }
}
