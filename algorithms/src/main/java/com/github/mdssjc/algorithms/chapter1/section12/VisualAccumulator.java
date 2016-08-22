package com.github.mdssjc.algorithms.chapter1.section12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Visual Accumulator Class.
 * 
 * @author Marcelo dos Santos
 *
 */
@TestDrive("1000")
public class VisualAccumulator {

  private final Accumulator acc;

  public VisualAccumulator(final int trials, final double max) {
    StdDraw.setXscale(0, trials);
    StdDraw.setYscale(0, max);
    StdDraw.setPenRadius(0.005);
    this.acc = new Accumulator();
  }

  public void addDataValue(final double val) {
    this.acc.addDataValue(val);
    StdDraw.setPenColor(StdDraw.DARK_GRAY);
    StdDraw.point(this.acc.getN(), val);
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.point(this.acc.getN(), this.acc.mean());
  }

  public double avg() {
    return this.acc.mean();
  }

  @Override
  public String toString() {
    return this.acc.toString();
  }

  public static void main(final String[] args) {
    Executor.execute(VisualAccumulator.class, args);

    final int T = Integer.parseInt(args[0]);
    final VisualAccumulator a = new VisualAccumulator(T, 1.0);
    for (int i = 0; i < T; i++) {
      a.addDataValue(StdRandom.random());
    }
    StdOut.println(a);
  }
}
