package com.github.mdssjc.algorithms.introcs.chapter1.section15;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 1.5.4 A simple filter.
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

    final int lo = Integer.parseInt(args[0]);
    final int hi = Integer.parseInt(args[1]);

    while (!StdIn.isEmpty()) {
      final int value = StdIn.readInt();
      if (value >= lo && value <= hi) {
        StdOut.print(value + " ");
      }
    }
    StdOut.println();
  }
}
