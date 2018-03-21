package com.github.mdssjc.algorithms.introcs.chapter3.section32;

import com.github.mdssjc.algorithms.introcs.chapter2.section22.Bernoulli;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdStats;

/**
 * Program 3.2.3 Histogram.
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
    StdDraw.setYscale(0, this.max);
    StdStats.plotBars(this.freq);
  }

  public static void main(final String[] args) {
    Executor.execute(Histogram.class, args);

    final int n = Integer.parseInt(args[0]);
    final int trials = Integer.parseInt(args[1]);
    final Histogram histogram = new Histogram(n + 1);
    StdDraw.setCanvasSize(500, 200);
    for (int t = 0; t < trials; t++) {
      histogram.addDataPoint(Bernoulli.binomial(n));
    }
    histogram.draw();
  }
}
