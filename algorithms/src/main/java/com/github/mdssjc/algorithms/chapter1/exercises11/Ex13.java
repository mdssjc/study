package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 13.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex13 {

  public static void main(final String[] args) {
    Executor.execute(Ex13.class, args);

    final int[][] xss = {
        {1, 1, 1},
        {2, 2, 2},
        {3, 4, 5}};

    for (final int[] result : transpose(xss)) {
      for (final int value : result) {
        StdOut.print(value);
      }
      StdOut.println();
    }
  }

  private static int[][] transpose(final int[][] xss) {
    final int rows = xss.length;
    final int cols = xss[0].length;

    final int[][] result = new int[cols][rows];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        result[j][i] = xss[i][j];
      }
    }
    return result;
  }
}
