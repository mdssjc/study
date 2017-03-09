package com.github.mdssjc.algorithms.chapter1.section12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Interval1D client.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Interval1DClient {

  public static void main(final String[] args) {
    Executor.execute(Interval1DClient.class, args);

    final Interval1D[] intervals = new Interval1D[4];
    intervals[0] = new Interval1D(15.0, 33.0);
    intervals[1] = new Interval1D(45.0, 60.0);
    intervals[2] = new Interval1D(20.0, 70.0);
    intervals[3] = new Interval1D(46.0, 55.0);

    StdOut.println("Unsorted");
    for (final Interval1D interval : intervals) {
      StdOut.println(interval);
    }
    StdOut.println();

    StdOut.println("Sort by min endpoint");
    Arrays.sort(intervals, Interval1D.MIN_ENDPOINT_ORDER);
    for (final Interval1D interval : intervals) {
      StdOut.println(interval);
    }
    StdOut.println();

    StdOut.println("Sort by max endpoint");
    Arrays.sort(intervals, Interval1D.MAX_ENDPOINT_ORDER);
    for (final Interval1D interval : intervals) {
      StdOut.println(interval);
    }
    StdOut.println();

    StdOut.println("Sort by length");
    Arrays.sort(intervals, Interval1D.LENGTH_ORDER);
    for (final Interval1D interval : intervals) {
      StdOut.println(interval);
    }
    StdOut.println();
  }
}
