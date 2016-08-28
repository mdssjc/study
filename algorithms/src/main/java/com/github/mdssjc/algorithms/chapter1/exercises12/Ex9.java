package com.github.mdssjc.algorithms.chapter1.exercises12;

import java.util.Arrays;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 9.
 * 
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = { "intsEven10" }, valueFile = true, input = { "1", "0",
    "3" })
public class Ex9 {

  public static int rank(final int key, final int[] a, final Counter counter) {
    int lo = 0;
    int hi = a.length - 1;

    while (lo <= hi) {
      counter.increment();

      final int mid = lo + (hi - lo) / 2;
      if (key < a[mid]) {
        hi = mid - 1;
      } else if (key > a[mid]) {
        lo = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  public static void main(final String[] args) {
    Executor.execute(Ex9.class, args);

    final int[] whitelist = In.readInts(args[0]);

    Arrays.sort(whitelist);

    final Counter counter = new Counter("keys");

    while (!StdIn.isEmpty()) {
      final int key = StdIn.readInt();
      if (rank(key, whitelist, counter) == -1) {
        StdOut.println(key);
      }
    }

    StdOut.println("Total of " + counter.tally() + " keys examined.");
  }
}
