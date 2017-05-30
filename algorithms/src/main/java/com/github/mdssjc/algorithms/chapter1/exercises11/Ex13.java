package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Exercise 1.1.13.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex13 {

  public static void main(final String[] args) {
    Executor.execute(Ex13.class, args);

    final int[][] matrix = {
        {1, 1, 1},
        {2, 2, 2},
        {3, 4, 5}};

    StdOut.println(Arrays.deepToString(matrix));
    StdOut.println(Arrays.deepToString(transpose(matrix)));
  }

  private static int[][] transpose(final int[][] matrix) {
    final int rows = matrix.length;
    final int cols = matrix[0].length;

    final int[][] result = new int[cols][rows];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        result[j][i] = matrix[i][j];
      }
    }
    return result;
  }
}
