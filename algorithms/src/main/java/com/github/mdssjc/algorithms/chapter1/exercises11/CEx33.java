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
interface Matrix {

  /**
   * Vector dot product.
   *
   * @param x
   *     Vector x
   * @param y
   *     Vector y
   *
   * @return Return x^T y
   */
  static double dot(final double[] x, final double[] y) {
    if (x.length != y.length) {
      throw new RuntimeException("Illegal vector dimensions.");
    }
    double sum = 0.0;
    for (int i = 0; i < x.length; i++) {
      sum += x[i] * y[i];
    }
    return sum;
  }

  /**
   * Matrix-matrix product.
   *
   * @param a
   *     Matrix a
   * @param b
   *     Matrix b
   *
   * @return Return c = a * b
   */
  static double[][] mult(final double[][] a, final double[][] b) {
    final int m1 = a.length;
    final int n1 = a[0].length;
    final int m2 = b.length;
    final int n2 = b[0].length;
    if (n1 != m2) {
      throw new RuntimeException("Illegal matrix dimensions.");
    }
    final double[][] c = new double[m1][n2];
    for (int i = 0; i < m1; i++) {
      for (int j = 0; j < n2; j++) {
        for (int k = 0; k < n1; k++) {
          c[i][j] += a[i][k] * b[k][j];
        }
      }
    }
    return c;
  }

  /**
   * Transpose.
   *
   * @param a
   *     Matrix A
   *
   * @return Return B = A^T
   */
  static double[][] transpose(final double[][] a) {
    final int m = a.length;
    final int n = a[0].length;
    final double[][] b = new double[n][m];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        b[j][i] = a[i][j];
      }
    }
    return b;
  }

  /**
   * Matrix-vector product.
   *
   * @param a
   *     Matrix A
   * @param x
   *     Vector x
   *
   * @return Matrix-vector multiplication (y = A * x)
   */
  static double[] mult(final double[][] a, final double[] x) {
    final int m = a.length;
    final int n = a[0].length;
    if (x.length != n) {
      throw new RuntimeException("Illegal matrix dimensions.");
    }
    final double[] y = new double[m];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        y[i] += a[i][j] * x[j];
      }
    }
    return y;
  }

  /**
   * Vector-matrix product.
   *
   * @param y
   *     Vector y
   * @param a
   *     Matrix A
   *
   * @return Vector-matrix multiplication (x = y^T A)
   */
  static double[] mult(final double[] y, final double[][] a) {
    final int m = a.length;
    final int n = a[0].length;
    if (y.length != m) {
      throw new RuntimeException("Illegal matrix dimensions.");
    }
    final double[] x = new double[n];
    for (int j = 0; j < n; j++) {
      for (int i = 0; i < m; i++) {
        x[j] += a[i][j] * y[i];
      }
    }
    return x;
  }
}

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
