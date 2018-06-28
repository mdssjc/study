package com.github.mdssjc.algorithms.chapter1;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * StdDraw plotting examples.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class PlottingExamples {

  public static void fn1() {
    final var n = 100;
    StdDraw.setXscale(0, n);
    StdDraw.setYscale(0, n * n);
    StdDraw.setPenRadius(.01);
    for (var i = 1; i <= n; i++) {
      StdDraw.point(i, i);
      StdDraw.point(i, i * i);
      StdDraw.point(i, i * Math.log(i));
    }
  }

  public static void fn2() {
    final var n = 50;
    final var a = new double[n];
    for (var i = 0; i < n; i++) {
      a[i] = StdRandom.random();
    }
    for (var i = 0; i < n; i++) {
      final var x = 1.0 * i / n;
      final var y = a[i] / 2.0;
      final var rw = 0.5 / n;
      final var rh = a[i] / 2.0;
      StdDraw.filledRectangle(x, y, rw, rh);
    }
  }

  public static void fn3() {
    final var n = 50;
    final var a = new double[n];
    for (var i = 0; i < n; i++) {
      a[i] = StdRandom.random();
    }
    Arrays.sort(a);
    for (var i = 0; i < n; i++) {
      final var x = 1.0 * i / n;
      final var y = a[i] / 2.0;
      final var rw = 0.5 / n;
      final var rh = a[i] / 2.0;
      StdDraw.filledRectangle(x, y, rw, rh);
    }
  }

  public static void main(final String[] args) {
    Executor.execute(PlottingExamples.class, args);

    StdOut.println("Function values");
    fn1();

    StdOut.println("Array of random values");
    fn2();

    StdOut.println("Sorted array of random values");
    fn3();
  }
}
