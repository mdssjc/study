package com.github.mdssjc.algorithms.chapter1.exercises12;

/**
 * Accumulator Class.
 *
 * @author Marcelo dos Santos
 *
 */
class Accumulator {

  private double m;
  private double s;
  private int n;

  public void addDataValue(final double x) {
    this.n++;
    this.s = this.s + 1.0 * (this.n - 1) / this.n * (x - this.m) * (x - this.m);
    this.m = this.m + (x - this.m) / this.n;
  }

  public double mean() {
    return this.m;
  }

  public double var() {
    return this.s / (this.n - 1);
  }

  public double stddev() {
    return Math.sqrt(this.var());
  }
}
