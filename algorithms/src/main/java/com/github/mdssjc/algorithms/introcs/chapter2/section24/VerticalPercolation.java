package com.github.mdssjc.algorithms.introcs.chapter2.section24;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdArrayIO;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

/**
 * Program 2.4.2 Vertical percolation detection.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "test5.txt", inputFile = true)
public class VerticalPercolation {

  public static boolean[][] flow(final boolean[][] isOpen) {
    final int n = isOpen.length;
    final boolean[][] isFull = new boolean[n][n];
    for (int j = 0; j < n; j++) {
      isFull[0][j] = isOpen[0][j];
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < n; j++) {
        isFull[i][j] = isOpen[i][j] && isFull[i - 1][j];
      }
    }
    return isFull;
  }

  public static boolean percolates(final boolean[][] isOpen) {
    final boolean[][] isFull = flow(isOpen);
    final int n = isOpen.length;
    for (int j = 0; j < n; j++) {
      if (isFull[n - 1][j]) {
        return true;
      }
    }
    return false;
  }

  public static void main(final String[] args) {
    Executor.execute(VerticalPercolation.class, args);

    final boolean[][] isOpen = StdArrayIO.readBoolean2D();
    StdArrayIO.print(flow(isOpen));
    StdOut.println(percolates(isOpen));
  }

  public static void show(final boolean[][] a, final boolean which) {
    final int n = a.length;
    StdDraw.setXscale(-1, n);
    StdDraw.setYscale(-1, n);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (a[i][j] == which) {
          StdDraw.filledSquare(j, n - i - 1, 0.5);
        }
      }
    }
  }

  public static boolean[][] random(final int n, final double p) {
    final boolean[][] a = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] = StdRandom.bernoulli(p);
      }
    }
    return a;
  }
}
