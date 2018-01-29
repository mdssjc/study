package com.github.mdssjc.algorithms.introcs.chapter1.section15;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 1.5.3 Averaging a stream of numbers.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = {"10.0", "5.0", "6.0", "3.0", "7.0", "32.0"})
public class Average {

  public static void main(final String[] args) {
    Executor.execute(Average.class, args);

    double sum = 0.0;
    int n = 0;

    while (!StdIn.isEmpty()) {
      final double value = StdIn.readDouble();
      sum += value;
      n++;
    }

    final double average = sum / n;
    StdOut.println("Average is " + average);
  }
}
