package com.github.mdssjc.algorithms.introcs.chapter1.section15;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 1.5.3 Averaging a stream of numbers.
 * <p>
 * Compilation:  javac Average.java
 * Execution:    java Average < data.txt
 * Dependencies: StdIn.java StdOut.java
 * <p>
 * Reads in a sequence of real numbers, and computes their average.
 * <p>
 * % java Average
 * 10.0 5.0 6.0
 * 3.0 7.0 32.0
 * <Ctrl-d>
 * Average is 10.5
 * <p>
 * Note <Ctrl-d> signifies the end of file on Unix.
 * On windows use <Ctrl-z>.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = {"10.0", "5.0", "6.0", "3.0", "7.0", "32.0"})
public class Average {

  public static void main(final String[] args) {
    Executor.execute(Average.class, args);

    var count = 0;
    var sum = 0.0;

    while (!StdIn.isEmpty()) {
      final var value = StdIn.readDouble();
      sum += value;
      count++;
    }

    final var average = sum / count;

    StdOut.println("Average is " + average);
  }
}
