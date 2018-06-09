package com.github.mdssjc.algorithms.introcs.chapter3.section32;

import com.github.mdssjc.algorithms.introcs.chapter2.section22.Bernoulli;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdStats;

/**
 * Program 3.2.3 Histogram.
 * <p>
 * Compilation:  javac Histogram.java
 * Execution:    java Histogram n trials
 * <p>
 * This data type supports simple client code to create dynamic
 * histograms of the frequency of occurrence of values in [0, N).
 * The frequencies are kept in an instance-variable array, and
 * an instance variable max tracks the maximum frequency (for scaling).
 * <p>
 * % java Histogram 50 1000000
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"50", "1000000"})
public class Histogram {

  private final double[] freq;
  private double max;

  public Histogram(final int n) {
    this.freq = new double[n];
  }

  public void addDataPoint(final int i) {
    this.freq[i]++;
    if (this.freq[i] > this.max) {
      this.max = this.freq[i];
    }
  }

  public void draw() {
    StdDraw.setYscale(-1, this.max + 1);
    StdStats.plotBars(this.freq);
  }

  public static void main(final String[] args) {
    Executor.execute(Histogram.class, args);

    final var n = Integer.parseInt(args[0]);
    final var trials = Integer.parseInt(args[1]);

    final var histogram = new Histogram(n + 1);
    for (var t = 0; t < trials; t++) {
      histogram.addDataPoint(Bernoulli.binomial(n));
    }

    StdDraw.setCanvasSize(500, 100);
    histogram.draw();
  }
}
