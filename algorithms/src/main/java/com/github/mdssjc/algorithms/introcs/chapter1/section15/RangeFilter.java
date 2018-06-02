package com.github.mdssjc.algorithms.introcs.chapter1.section15;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 1.5.4 A simple filter.
 * <p>
 * Compilation:  javac RangeFilter.java
 * Execution:    java RangeFilter lo hi < input.txt
 * Dependencies: StdIn.java StdOut.java
 * <p>
 * Read in a sequence of integers from standard input and print
 * out those values between lo and hi.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(
    value = {"100", "400"},
    input = {"358", "1330", "55", "165", "689", "1014", "3066", "387", "575",
        "843", "203", "48", "292", "877", "65", "998"})
public class RangeFilter {

  public static void main(final String[] args) {
    Executor.execute(RangeFilter.class, args);

    final var lo = Integer.parseInt(args[0]);
    final var hi = Integer.parseInt(args[1]);

    while (!StdIn.isEmpty()) {
      final var t = StdIn.readInt();

      if (t >= lo && t <= hi) {
        StdOut.print(t + " ");
      }
    }
    StdOut.println();
  }
}
