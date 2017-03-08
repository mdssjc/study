package com.github.mdssjc.algorithms.chapter1.section11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Average of a sequence of numbers.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "1.23456 2.34567 3.45678 4.56789")
@TestDrive(input = "10.0 5.0 6.0 3.0 7.0 32.0")
public class Average {

  public static void main(final String[] args) {
    Executor.execute(Average.class, args);

    int count = 0;
    double sum = 0.0;

    while (!StdIn.isEmpty()) {
      sum += StdIn.readDouble();
      count++;
    }

    final double average = sum / count;
    StdOut.printf("Average is %.5f%n", average);
  }
}
