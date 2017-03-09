package com.github.mdssjc.algorithms.chapter1.section12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.Accumulator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Accumulator client.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "0.5 1 3.5 6 12 12.1 12.2 20")
public class AccumulatorClient {

  public static void main(final String[] args) {
    Executor.execute(AccumulatorClient.class, args);

    final Accumulator stats = new Accumulator();
    while (!StdIn.isEmpty()) {
      final double x = StdIn.readDouble();
      stats.addDataValue(x);
    }

    StdOut.printf("n      = %d%n", stats.count());
    StdOut.printf("mean   = %.5f%n", stats.mean());
    StdOut.printf("stddev = %.5f%n", stats.stddev());
    StdOut.printf("var    = %.5f%n", stats.var());
  }
}
