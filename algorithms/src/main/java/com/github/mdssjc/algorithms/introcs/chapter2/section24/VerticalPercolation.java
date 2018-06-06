package com.github.mdssjc.algorithms.introcs.chapter2.section24;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdArrayIO;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

/**
 * Program 2.4.2 Vertical percolation detection.
 * <p>
 * Compilation:  javac VerticalPercolation.java
 * Execution:    java VerticalPercolation < input.txt
 * Dependencies: StdArrayIO.java StdOut.java
 * Data files:   http://www.cs.princeton.edu/introcs/24percolation/test5.txt
 *               http://www.cs.princeton.edu/introcs/24percolation/test8.txt
 *               http://www.cs.princeton.edu/introcs/24percolation/testD.txt
 *               http://www.cs.princeton.edu/introcs/24percolation/testV.txt
 *               http://www.cs.princeton.edu/introcs/24percolation/testT.txt
 *               http://www.cs.princeton.edu/introcs/24percolation/testF.txt
 *               http://www.cs.princeton.edu/introcs/24percolation/testTiny.txt
 *               https://introcs.cs.princeton.edu/24percolation/testV.txt
 * <p>
 * % java VerticalPercolation < test5.txt
 * 5 5
 * 0 1 1 0 1
 * 0 0 1 0 1
 * 0 0 0 0 1
 * 0 0 0 0 1
 * 0 0 0 0 1
 * true
 * <p>
 * % java VerticalPercolation < testD.txt
 * 8 8
 * 0 0 0 1 1 1 0 1
 * 0 0 0 0 0 1 0 1
 * 0 0 0 0 0 1 0 0
 * 0 0 0 0 0 1 0 0
 * 0 0 0 0 0 1 0 0
 * 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0
 * false
 * <p>
 * % java VerticalPercolation < testV.txt
 * 8 8
 * 0 0 0 1 1 1 0 1
 * 0 0 0 0 0 1 0 1
 * 0 0 0 0 0 1 0 0
 * 0 0 0 0 0 1 0 0
 * 0 0 0 0 0 1 0 0
 * 0 0 0 0 0 1 0 0
 * 0 0 0 0 0 1 0 0
 * 0 0 0 0 0 1 0 0
 * true
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "test5.txt", inputFile = true)
@TestDrive(input = "testV.txt", inputFile = true)
public class VerticalPercolation {

  public static boolean[][] flow(final boolean[][] isOpen) {
    final var n = isOpen.length;
    final var isFull = new boolean[n][n];

    for (var j = 0; j < n; j++) {
      isFull[0][j] = isOpen[0][j];
    }

    for (var i = 1; i < n; i++) {
      for (var j = 0; j < n; j++) {
        isFull[i][j] = isOpen[i][j] && isFull[i - 1][j];
      }
    }

    return isFull;
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
    Executor.execute(VerticalPercolation.class, args);

    final var isOpen = StdArrayIO.readBoolean2D();
    StdArrayIO.print(flow(isOpen));
    StdOut.println(percolates(isOpen));
  }
}
