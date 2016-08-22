package com.github.mdssjc.algorithms.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 2.
 * 
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = { "3" }, input = { "1", "2", "2", "3", "4", "5" })
public class Ex2 {

  public static void main(final String[] args) {
    Executor.test(Ex2.class, args);

    final int N = Integer.parseInt(args[0]);

    final Interval1D[] intervals = new Interval1D[N];
    for (int i = 0; i < N; i++) {
      intervals[i] = new Interval1D(StdIn.readDouble(), StdIn.readDouble());
    }

    for (int i = 0; i < intervals.length; i++) {
      for (int j = i + 1; j < intervals.length; j++) {
        if (intervals[i].intersects(intervals[j])) {
          StdOut.println(intervals[i] + " " + intervals[j]);
        }
      }
    }
  }
}
