package com.github.mdssjc.algorithms.chapter1.section11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Average Class.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( input = "1.23 2.34 3.45 4.56" )
public class Average {

  public static void main(final String[] args) {
    Executor.execute(Average.class, args);

    // Average the numbers on StdIn.
    double sum = 0.0;
    int cnt = 0;
    while (!StdIn.isEmpty()) {
      // Read a number and cumulate the sum.
      sum += StdIn.readDouble();
      cnt++;
    }
    final double avg = sum / cnt;
    StdOut.printf("Average is %.5f\n", avg);
  }
}
