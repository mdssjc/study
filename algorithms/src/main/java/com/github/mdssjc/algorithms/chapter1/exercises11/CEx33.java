package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Creative Exercise 33.
 * <p>
 * Matrix library.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = {"1 2 3 4 5 6 9 1 3 1 2 3"})
public class CEx33 {

  private static final int LENGTH = 3;

  public static void main(final String[] args) {
    Executor.execute(CEx33.class, args);

    final double[][] matrix = new double[LENGTH][LENGTH];
    final double[] vector = new double[LENGTH];

    StdOut.printf("Enter values to [%1$dx%1$d] and [%1$d]%n", LENGTH);
    while (!StdIn.isEmpty()) {
      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
          matrix[i][j] = StdIn.readDouble();
        }
      }

      for (int i = 0; i < vector.length; i++) {
        vector[i] = StdIn.readDouble();
      }
    }

    StdArrayIO.print(matrix);
    StdArrayIO.print(vector);

    StdOut.println(Matrix.dot(vector, vector));
    StdArrayIO.print(Matrix.mult(matrix, matrix));
    StdArrayIO.print(Matrix.transpose(matrix));
    StdArrayIO.print(Matrix.mult(matrix, vector));
    StdArrayIO.print(Matrix.mult(vector, matrix));
  }
}
