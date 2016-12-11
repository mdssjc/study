package com.github.mdssjc.algorithms.chapter1.exercises12;

import edu.princeton.cs.algs4.StdDraw;

/**
 * VisualCounter Class.
 *
 * @author Marcelo dos Santos
 *
 */
class VisualCounter {

  private final int max;
  private int n;
  private double posX;
  private int counter;

  public VisualCounter(final int n, final int max) {
    this.n = n;
    this.max = max;
    this.posX = -0.5;
    StdDraw.setXscale(0, n);
    StdDraw.setYscale(0, 2 * max);
    StdDraw.setPenRadius(0.025);
  }

  public void increment() {
    if (this.n > 0 && Math.abs(this.counter) != this.max) {
      this.counter++;
      draw();
    }
  }

  public void decrement() {
    if (this.n > 0 && Math.abs(this.counter) != this.max) {
      this.counter--;
      draw();
    }
  }

  private void draw() {
    this.n--;
    StdDraw.point(++this.posX, this.counter + this.max);
  }
}
