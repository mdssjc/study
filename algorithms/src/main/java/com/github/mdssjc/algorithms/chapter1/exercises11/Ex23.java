package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.chapter1.section11.BinarySearch;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.stream.IntStream;

/**
 * Exercise 23.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( input = "29 30 31 59 60 61" )
public class Ex23 {

  public static void main(final String[] args) {
    Executor.execute(Ex23.class, args);

    final int[] whitelist = IntStream.range(30, 60)
                                     .sorted()
                                     .toArray();

    while (!StdIn.isEmpty()) {
      final int key = StdIn.readInt();
      if (BinarySearch.rank(key, whitelist) == -1) {
        StdOut.print("- ");
      } else {
        StdOut.print("+ ");
      }
      StdOut.println(key);
    }
  }
}
