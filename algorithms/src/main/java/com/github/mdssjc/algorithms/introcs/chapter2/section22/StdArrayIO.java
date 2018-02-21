package com.github.mdssjc.algorithms.introcs.chapter2.section22;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 2.2.2 Array I/O library.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "tinyDouble2D.txt", inputFile = true)
public class StdArrayIO {

  public static double[] readDouble1D() {
    final int n = StdIn.readInt();
    final double[] a = new double[n];
    for (int i = 0; i < n; i++) {
      a[i] = StdIn.readDouble();
    }
    return a;
  }

  public static double[][] readDouble2D() {
    final int m = StdIn.readInt();
    final int n = StdIn.readInt();
    final double[][] a = new double[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] = StdIn.readDouble();
      }
    }
    return a;
  }

  public static void print(final double[] a) {
    final int n = a.length;
    StdOut.println(n);
    for (int i = 0; i < n; i++) {
      StdOut.printf("%9.5f ", a[i]);
    }
    StdOut.println();
  }

  public static void print(final double[][] a) {
    final int m = a.length;
    final int n = a[0].length;
    System.out.println(m + " " + n);
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        StdOut.printf("%9.5f ", a[i][j]);
      }
      StdOut.println();
    }
    StdOut.println();
  }

  public static void main(final String[] args) {
    Executor.execute(StdArrayIO.class, args);

    print(readDouble2D());
  }
}
