package com.github.mdssjc.algorithms.introcs.chapter2.section24;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdArrayIO;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 2.4.1 Percolation scaffolding.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "test5.txt", inputFile = true)
public class Percolation {

  public static boolean[][] flow(final boolean[][] isOpen) {
    final int n = isOpen.length;
    final boolean[][] isFull = new boolean[n][n];
    // The isFull[][] matrix computation goes here.
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
    Executor.execute(Percolation.class, args);

    final boolean[][] isOpen = StdArrayIO.readBoolean2D();
    StdArrayIO.print(flow(isOpen));
    StdOut.println(percolates(isOpen));
  }
}
