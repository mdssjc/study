package com.github.mdssjc.algorithms.chapter1.section12;

import edu.princeton.cs.algs4.StdDraw;

/**
 * Visual Accumulator Class.
 * 
 * @author Marcelo dos Santos
 *
 */
public class VisualAccumulator {

  private Accumulator acc;

  public VisualAccumulator(int trials, double max) {
    StdDraw.setXscale(0, trials);
    StdDraw.setYscale(0, max);
    StdDraw.setPenRadius(0.005);
    acc = new Accumulator();
  }

  public void addDataValue(double val) {
    acc.addDataValue(val);
    StdDraw.setPenColor(StdDraw.DARK_GRAY);
    StdDraw.point(acc.getN(), val);
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.point(acc.getN(), acc.mean());
  }

  public double avg() {
    return acc.mean();
  }

  @Override
  public String toString() {
    return acc.toString();
  }
}
