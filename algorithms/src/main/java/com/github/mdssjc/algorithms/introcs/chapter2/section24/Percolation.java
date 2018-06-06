package com.github.mdssjc.algorithms.introcs.chapter2.section24;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdArrayIO;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

/**
 * Program 2.4.1 Percolation scaffolding.
 * Program 2.4.5 Percolation detection.
 * <p>
 * Compilation:  javac Percolation.java
 * Execution:    java Percolation < input.txt
 * Dependencies: StdArrayIO.java StdDraw.java StdOut.java
 * Data files:   http://www.cs.princeton.edu/introcs/24percolation/test5.txt
 *               http://www.cs.princeton.edu/introcs/24percolation/test8.txt
 *               http://www.cs.princeton.edu/introcs/24percolation/testD.txt
 *               http://www.cs.princeton.edu/introcs/24percolation/testV.txt
 *               http://www.cs.princeton.edu/introcs/24percolation/testT.txt
 *               http://www.cs.princeton.edu/introcs/24percolation/testF.txt
 *               http://www.cs.princeton.edu/introcs/24percolation/testTiny.txt
 * <p>
 * % more test5.txt
 * 5 5
 * 0 1 1 0 1
 * 0 0 1 1 1
 * 1 1 0 1 1
 * 1 0 0 0 1
 * 0 1 1 1 1
 * <p>
 * % java Percolation < test5.txt
 * 5 5
 * 0 1 1 0 1
 * 0 0 1 1 1
 * 0 0 0 1 1
 * 0 0 0 0 1
 * 0 1 1 1 1
 * true
 * <p>
 * % more testD.txt
 * 8 8
 * 0 0 0 1 1 1 0 1
 * 1 1 1 0 0 1 1 1
 * 1 0 1 0 0 1 0 0
 * 1 0 1 1 1 1 0 1
 * 1 0 0 1 0 1 0 0
 * 1 1 0 1 0 0 1 0
 * 0 1 1 0 0 1 1 1
 * 0 0 1 0 0 0 0 0
 * <p>
 * % java Percolation < testD.txt
 * 8 8
 * 0 0 0 1 1 1 0 1
 * 1 1 1 0 0 1 1 1
 * 1 0 1 0 0 1 0 0
 * 1 0 1 1 1 1 0 0
 * 1 0 0 1 0 1 0 0
 * 1 1 0 1 0 0 0 0
 * 0 1 1 0 0 0 0 0
 * 0 0 1 0 0 0 0 0
 * true
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "test5.txt", inputFile = true)
@TestDrive(input = "testD.txt", inputFile = true)
public class Percolation {

  public static boolean[][] flow(final boolean[][] isOpen) {
    final var n = isOpen.length;
    final var isFull = new boolean[n][n];
    for (var j = 0; j < n; j++) {
      flow(isOpen, isFull, 0, j);
    }
    return isFull;
  }

  public static void flow(final boolean[][] isOpen, final boolean[][] isFull, final int i, final int j) {
    final var n = isOpen.length;

    if (i < 0 || i >= n) {
      return;
    }
    if (j < 0 || j >= n) {
      return;
    }
    if (!isOpen[i][j]) {
      return;
    }
    if (isFull[i][j]) {
      return;
    }

    isFull[i][j] = true;

    flow(isOpen, isFull, i + 1, j);
    flow(isOpen, isFull, i, j + 1);
    flow(isOpen, isFull, i, j - 1);
    flow(isOpen, isFull, i - 1, j);
  }

  public static boolean percolates(final boolean[][] isOpen) {
    final var n = isOpen.length;
    final var isFull = flow(isOpen);
    for (var j = 0; j < n; j++) {
      if (isFull[n - 1][j]) {
        return true;
      }
    }
    return false;
  }

  public static void show(final boolean[][] a, final boolean which) {
    final var n = a.length;
    StdDraw.setXscale(-1, n);
    StdDraw.setYscale(-1, n);
    for (var i = 0; i < n; i++) {
      for (var j = 0; j < n; j++) {
        if (a[i][j] == which) {
          StdDraw.filledSquare(j, n - i - 1, 0.5);
        }
      }
    }
  }

  public static boolean[][] random(final int n, final double p) {
    final var a = new boolean[n][n];
    for (var i = 0; i < n; i++) {
      for (var j = 0; j < n; j++) {
        a[i][j] = StdRandom.bernoulli(p);
      }
    }
    return a;
  }

  public static void main(final String[] args) {
    Executor.execute(Percolation.class, args);

    final var isOpen = StdArrayIO.readBoolean2D();
    StdArrayIO.print(flow(isOpen));
    StdOut.println(percolates(isOpen));
  }
}
