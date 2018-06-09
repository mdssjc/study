package com.github.mdssjc.algorithms.introcs.chapter4.section42;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Arrays;

/**
 * Program 4.2.3 Binary search (sorted array).
 * <p>
 * Compilation:  javac BinarySearch.java
 * Execution:    java BinarySearch wordlist.txt < input.txt
 * Data files:   http://www.cs.princeton.edu/introcs/43sort/emails.txt
 *               http://www.cs.princeton.edu/introcs/43sort/whitelist.txt
 * <p>
 * Read in an alphabetical list of words from the given file.
 * Then prompt the user to enter words. The program reports which
 * words are *not* in the wordlist.
 * <p>
 * % java BinarySearch whitelist.txt < emails.html
 * marvin@spam
 * mallory@spam
 * eve@airport
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = "whitelist.txt", input = "emails.txt", inputFile = true)
public class BinarySearch {

  public static int search(final String key, final String[] a) {
    return search(key, a, 0, a.length);
  }

  public static int search(final String key, final String[] a, final int lo, final int hi) {
    System.out.println("lo  = " + lo);
    System.out.println("hi  = " + hi);

    if (hi <= lo) {
      return -1;
    }
    final var mid = lo + (hi - lo) / 2;
    final var cmp = a[mid].compareTo(key);
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

    final var in = new In(args[0]);
    final var s = in.readAll();
    final var words = s.split("\\s+");
    System.err.println("Done reading words");

    Arrays.sort(words);
    System.err.println("Done sorting words");

    while (!StdIn.isEmpty()) {
      final var key = StdIn.readString();
      if (search(key, words) < 0) {
        StdOut.println(key);
      }
    }
  }
}
