package com.github.mdssjc.algorithms.chapter1;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdArrayIO;
import edu.princeton.cs.introcs.StdOut;

/**
 * Typical array-processing code.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class TypicalArrayCodes {

  public static double maximum(final double[] a) {
    var max = a[0];
    for (var i = 1; i < a.length; i++) {
      if (a[i] > max) {
        max = a[i];
      }
    }
    return max;
  }

  public static double average(final double[] a) {
    final var N = a.length;
    var sum = 0.0;
    for (var i = 0; i < N; i++) {
      sum += a[i];
    }
    final var average = sum / N;
    return average;
  }

  public static double[] copy(final double[] a) {
    final var N = a.length;
    final var b = new double[N];
    for (var i = 0; i < N; i++) {
      b[i] = a[i];
    }
    return b;
  }

  public static void reverse(final double[] a) {
    final var N = a.length;
    for (var i = 0; i < N / 2; i++) {
      final var temp = a[i];
      a[i] = a[N - 1 - i];
      a[N - i - 1] = temp;
    }
  }

  public static double[][] multiplication(final double[][] a, final double[][] b) {
    final var N = a.length;
    final var c = new double[N][N];
    for (var i = 0; i < N; i++) {
      for (var j = 0; j < N; j++) {
        for (var k = 0; k < N; k++) {
          c[i][j] += a[i][k] * b[k][j];
        }
      }
    }
    return c;
  }

  public static void main(final String[] args) {
    Executor.execute(TypicalArrayCodes.class, args);

    final double[] a = {1.0, 3.0, 5.0, 10.0};
    final double[] b = {10.0, 9.0, 6.0, 2.0};

    StdOut.println("Find the maximum of the array values");
    StdOut.println(maximum(a));
    StdOut.println(maximum(b));

    StdOut.println("Compute the average of the array values");
    StdOut.println(average(a));
    StdOut.println(average(b));

    StdOut.println("Copy to another array");
    final var c = copy(a);
    StdArrayIO.print(a);
    StdArrayIO.print(c);

    StdOut.println("Reverse the elements within an array");
    StdArrayIO.print(a);
    reverse(a);
    StdArrayIO.print(a);

    StdOut.println("Matrix-matrix multiplication (square matrices)");
    StdOut.println("a[][]*b[][] = c[][]");
    final double[][] a2 = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};
    final double[][] b2 = {{5.0, 2.5, 1.0}, {20.0, 10.0, 5.0}};
    StdArrayIO.print(multiplication(a2, b2));
  }
}
