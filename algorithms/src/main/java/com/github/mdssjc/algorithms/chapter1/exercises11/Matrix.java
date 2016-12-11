package com.github.mdssjc.algorithms.chapter1.exercises11;

/**
 * Matrix Interface.
 *
 * @author Marcelo dos Santos
 *
 */
public interface Matrix {

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
