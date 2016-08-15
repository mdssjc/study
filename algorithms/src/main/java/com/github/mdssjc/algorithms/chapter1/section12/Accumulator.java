package com.github.mdssjc.algorithms.chapter1.section12;

/**
 * Accumulator Class.
 * 
 * @author Marcelo dos Santos
 *
 */
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

  @Override
  public String toString() {
    return "Mean (" + this.N + " values): " + String.format("%7.5f", mean());
  }
}
