package com.github.mdssjc.algorithms.chapter1.section11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Average - Sample StdOut client.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "1.23456 2.34567 3.45678 4.56789")
public class Average {

  public static void main(final String[] args) {
    Executor.execute(Average.class, args);

    double sum = 0.0;
    int cnt = 0;

    while (!StdIn.isEmpty()) {
      sum += StdIn.readDouble();
      cnt++;
    }
    final double avg = sum / cnt;
    StdOut.printf("Average is %.5f%n", avg);
  }
}
