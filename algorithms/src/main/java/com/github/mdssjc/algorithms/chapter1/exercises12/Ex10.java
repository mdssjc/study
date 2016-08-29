package com.github.mdssjc.algorithms.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Exercício 10.
 * 
 * @author Marcelo dos Santos
 *
 */
@TestDrive({ "10", "10" })
public class Ex10 {

  private int       n;
  private double    posX;
  private final int max;
  private int       counter;

  public Ex10(final int n, final int max) {
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

  public static void main(final String[] args) {
    Executor.execute(Ex10.class, args);

    final int N = Integer.parseInt(args[0]);
    final int max = Integer.parseInt(args[1]);

    final Ex10 vc = new Ex10(N, max);
    for (int i = 0; i < N; i++) {
      if (StdRandom.bernoulli()) {
        vc.increment();
      } else {
        vc.decrement();
      }
    }

    try {
      Thread.sleep(5000);
    } catch (final InterruptedException e) {
      e.printStackTrace();
    }
  }
}
