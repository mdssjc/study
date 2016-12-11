package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdOut;

/**
 * Creative Exercise 33.
 * <p>
 * Matrix library.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class CEx33 {

  public static void main(final String[] args) {
    Executor.execute(CEx33.class, args);

    final double[][] matrix = {{1, 2, 3}, {4, 5, 6}, {9, 1, 3}};
    final double[] vector = {1, 2, 3};

    StdArrayIO.print(matrix);
    StdArrayIO.print(vector);

    final double dot = Matrix.dot(vector, vector);
    StdOut.println(dot);

    final double[][] mult = Matrix.mult(matrix, matrix);
    StdArrayIO.print(mult);

    final double[][] transpose = Matrix.transpose(matrix);
    StdArrayIO.print(transpose);

    final double[] multmv = Matrix.mult(matrix, vector);
    StdArrayIO.print(multmv);

    final double[] multvm = Matrix.mult(vector, matrix);
    StdArrayIO.print(multvm);
  }
}
