package com.github.mdssjc.algorithms.chapter1.exercises12;

import edu.princeton.cs.algs4.StdDraw;

/**
 * Visual Counter.
 * 
 * @author Marcelo dos Santos
 *
 */
public class VisualCounter {

  private int    n;
  private double posX;
  private int    max;
  private int    counter;

  public VisualCounter(int n, int max) {
    this.n = n;
    this.max = max;
    posX = -0.5;
    StdDraw.setXscale(0, n);
    StdDraw.setYscale(0, 2 * max);
    StdDraw.setPenRadius(0.025);
  }

  public void increment() {
    if (n > 0 && Math.abs(counter) != max) {
      counter++;
      draw();
    }
  }

  public void decrement() {
    if (n > 0 && Math.abs(counter) != max) {
      counter--;
      draw();
    }
  }

  private void draw() {
    n--;
    StdDraw.point(++posX, counter + max);
  }
}
