package com.github.mdssjc.algorithms.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdStats;

/**
 * Creative Exercise 18.
 * <p>
 * Variance for accumulator.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class CEx18 {

  public static void main(final String[] args) {
    Executor.execute(CEx18.class, args);

    final Accumulator acc = new Accumulator();
    acc.addDataValue(6.2);
    acc.addDataValue(12.5);
    acc.addDataValue(8.8);
    acc.addDataValue(3.1);
    acc.addDataValue(11.0);

    final double[] values = {6.2, 12.5, 8.8, 3.1, 11.0};

    StdOut.println(acc.mean() + " = " + StdStats.mean(values));
    StdOut.println(acc.var() + " = " + StdStats.var(values));
    StdOut.println(acc.stddev() + " + " + StdStats.stddev(values));
  }
}
