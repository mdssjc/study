package com.github.mdssjc.algorithms.chapter1.section12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Accumulator Class.
 * 
 * @author Marcelo dos Santos
 *
 */
@TestDrive("1000")
@TestDrive("1000000")
@TestDrive("1000000")
public class Accumulator {

  private double total;
  private int    N;

  public void addDataValue(final double val) {
    this.N++;
    this.total += val;
  }

  public double mean() {
    return this.total / this.N;
  }

  public int getN() {
    return this.N;
  }

  @Override
  public String toString() {
    return "Mean (" + this.N + " values): " + String.format("%7.5f", mean());
  }

  public static void main(final String[] args) {
    Executor.test(Accumulator.class, args);

    final int T = Integer.parseInt(args[0]);
    final Accumulator a = new Accumulator();
    for (int i = 0; i < T; i++) {
      a.addDataValue(StdRandom.random());
    }
    StdOut.println(a);
  }
}
