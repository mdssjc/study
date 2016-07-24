package com.github.mdssjc.algorithms.chapter1.exercises1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 11.
 * 
 * @author Marcelo dos Santos
 *
 */
public class Ex11 {

  public static void main(final String[] args) {
    final boolean[][] matrix = {
        { true, true, true, true, true },
        { true, false, false, false, true },
        { true, false, true, false, true },
        { true, false, false, false, true },
        { true, true, true, true, true } };

    for (int row = 0; row < matrix.length; row++) {
      final int length = matrix[row].length;

      if (row == 0) {
        StdOut.print("  ");
        for (int col = 0; col < length; col++) {
          StdOut.print(col);
        }
        StdOut.println();
      }

      StdOut.print(row + " ");
      for (int col = 0; col < length; col++) {
        StdOut.print((matrix[row][col] == true) ? "*" : " ");
      }
      StdOut.println();
    }
  }
}
