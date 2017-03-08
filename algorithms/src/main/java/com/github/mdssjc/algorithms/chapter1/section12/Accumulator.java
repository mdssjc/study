package com.github.mdssjc.algorithms.chapter1.section12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Accumulator data type.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("1000")
@TestDrive("1000000")
@TestDrive("1000000")
public class Accumulator {

  private double total;
  private int n;

  public static void main(final String[] args) {
    Executor.execute(Accumulator.class, args);

    final int trails = Integer.parseInt(args[0]);
    final Accumulator a = new Accumulator();
    for (int i = 0; i < trails; i++) {
      a.addDataValue(StdRandom.uniform());
    }
    StdOut.println(a);
  }

  public void addDataValue(final double val) {
    this.n++;
    this.total += val;
  }

  public double mean() {
    return this.total / this.n;
  }

  public int getN() {
    return this.n;
  }

  @Override
  public String toString() {
    return String.format("Mean (%d values): %7.5f", n, mean());
  }
}
