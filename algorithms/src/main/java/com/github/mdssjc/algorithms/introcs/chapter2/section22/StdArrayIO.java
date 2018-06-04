package com.github.mdssjc.algorithms.introcs.chapter2.section22;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 2.2.2 Array I/O library.
 * <p>
 * Compilation:  javac StdArrayIO.java
 * Execution:    java StdArrayIO < input.txt
 * Dependencies: StdOut.java
 * Data files:    https://introcs.cs.princeton.edu/java/22library/tinyDouble1D.txt
 * https://introcs.cs.princeton.edu/java/22library/tinyDouble2D.txt
 * https://introcs.cs.princeton.edu/java/22library/tinyBoolean2D.txt
 * <p>
 * A library for reading in 1D and 2D arrays of integers, doubles,
 * and booleans from standard input and printing them out to
 * standard output.
 * <p>
 * % more tinyDouble1D.txt
 * 4
 *   .000  .246  .222  -.032
 * <p>
 * % more tinyDouble2D.txt
 * 4 3
 *   .000  .270  .000
 *   .246  .224 -.036
 *   .222  .176  .0893
 *  -.032  .739  .270
 * <p>
 * % more tinyBoolean2D.txt
 * 4 3
 *   1 1 0
 *   0 0 0
 *   0 1 1
 *   1 1 1
 * <p>
 * % cat tinyDouble1D.txt tinyDouble2D.txt tinyBoolean2D.txt | java StdArrayIO
 * 4
 *   0.00000   0.24600   0.22200  -0.03200
 * <p>
 * 4 3
 *   0.00000   0.27000   0.00000
 *   0.24600   0.22400  -0.03600
 *   0.22200   0.17600   0.08930
 *   0.03200   0.73900   0.27000
 * <p>
 * 4 3
 * 1 1 0
 * 0 0 0
 * 0 1 1
 * 1 1 1
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = {"tinyDouble1D.txt", "tinyDouble2D.txt", "tinyBoolean2D.txt"}, inputFile = true)
/**
 *  <i>Standard array IO</i>. This class provides methods for reading
 *  in 1D and 2D arrays from standard input and printing out to
 *  standard output.
 *  <p>
 *  For additional documentation, see
 *  <a href="https://introcs.cs.princeton.edu/22libary">Section 2.2</a> of
 *  <i>Computer Science: An Interdisciplinary Approach</i>
 *  by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class StdArrayIO {

  // it doesn't make sense to instantiate this class
  private StdArrayIO() {
  }

  /**
   * Reads a 1D array of doubles from standard input and returns it.
   *
   * @return the 1D array of doubles
   */
  public static double[] readDouble1D() {
    final var n = StdIn.readInt();
    final var a = new double[n];
    for (var i = 0; i < n; i++) {
      a[i] = StdIn.readDouble();
    }
    return a;
  }

  /**
   * Prints an array of doubles to standard output.
   *
   * @param a
   *     the 1D array of doubles
   */
  public static void print(final double[] a) {
    final var n = a.length;
    StdOut.println(n);
    for (var i = 0; i < n; i++) {
      StdOut.printf("%9.5f ", a[i]);
    }
    StdOut.println();
  }


  /**
   * Reads a 2D array of doubles from standard input and returns it.
   *
   * @return the 2D array of doubles
   */
  public static double[][] readDouble2D() {
    final var m = StdIn.readInt();
    final var n = StdIn.readInt();
    final var a = new double[m][n];
    for (var i = 0; i < m; i++) {
      for (var j = 0; j < n; j++) {
        a[i][j] = StdIn.readDouble();
      }
    }
    return a;
  }

  /**
   * Prints the 2D array of doubles to standard output.
   *
   * @param a
   *     the 2D array of doubles
   */
  public static void print(final double[][] a) {
    final var m = a.length;
    final var n = a[0].length;
    StdOut.println(m + " " + n);
    for (var i = 0; i < m; i++) {
      for (var j = 0; j < n; j++) {
        StdOut.printf("%9.5f ", a[i][j]);
      }
      StdOut.println();
    }
  }

  /**
   * Reads a 1D array of integers from standard input and returns it.
   *
   * @return the 1D array of integers
   */
  public static int[] readInt1D() {
    final var n = StdIn.readInt();
    final var a = new int[n];
    for (var i = 0; i < n; i++) {
      a[i] = StdIn.readInt();
    }
    return a;
  }

  /**
   * Prints an array of integers to standard output.
   *
   * @param a
   *     the 1D array of integers
   */
  public static void print(final int[] a) {
    final var n = a.length;
    StdOut.println(n);
    for (var i = 0; i < n; i++) {
      StdOut.printf("%9d ", a[i]);
    }
    StdOut.println();
  }

  /**
   * Reads a 2D array of integers from standard input and returns it.
   *
   * @return the 2D array of integers
   */
  public static int[][] readInt2D() {
    final var m = StdIn.readInt();
    final var n = StdIn.readInt();
    final var a = new int[m][n];
    for (var i = 0; i < m; i++) {
      for (var j = 0; j < n; j++) {
        a[i][j] = StdIn.readInt();
      }
    }
    return a;
  }

  /**
   * Print a 2D array of integers to standard output.
   *
   * @param a
   *     the 2D array of integers
   */
  public static void print(final int[][] a) {
    final var m = a.length;
    final var n = a[0].length;
    StdOut.println(m + " " + n);
    for (var i = 0; i < m; i++) {
      for (var j = 0; j < n; j++) {
        StdOut.printf("%9d ", a[i][j]);
      }
      StdOut.println();
    }
  }

  /**
   * Reads a 1D array of booleans from standard input and returns it.
   *
   * @return the 1D array of booleans
   */
  public static boolean[] readBoolean1D() {
    final var n = StdIn.readInt();
    final var a = new boolean[n];
    for (var i = 0; i < n; i++) {
      a[i] = StdIn.readBoolean();
    }
    return a;
  }

  /**
   * Prints a 1D array of booleans to standard output.
   *
   * @param a
   *     the 1D array of booleans
   */
  public static void print(final boolean[] a) {
    final var n = a.length;
    StdOut.println(n);
    for (var i = 0; i < n; i++) {
      if (a[i]) {
        StdOut.print("1 ");
      } else {
        StdOut.print("0 ");
      }
    }
    StdOut.println();
  }

  /**
   * Reads a 2D array of booleans from standard input and returns it.
   *
   * @return the 2D array of booleans
   */
  public static boolean[][] readBoolean2D() {
    final var m = StdIn.readInt();
    final var n = StdIn.readInt();
    final var a = new boolean[m][n];
    for (var i = 0; i < m; i++) {
      for (var j = 0; j < n; j++) {
        a[i][j] = StdIn.readBoolean();
      }
    }
    return a;
  }

  /**
   * Prints a 2D array of booleans to standard output.
   *
   * @param a
   *     the 2D array of booleans
   */
  public static void print(final boolean[][] a) {
    final var m = a.length;
    final var n = a[0].length;
    StdOut.println(m + " " + n);
    for (var i = 0; i < m; i++) {
      for (var j = 0; j < n; j++) {
        if (a[i][j]) {
          StdOut.print("1 ");
        } else {
          StdOut.print("0 ");
        }
      }
      StdOut.println();
    }
  }

  /**
   * Unit tests {@code StdArrayIO}.
   *
   * @param args
   *     the command-line arguments
   */
  public static void main(final String[] args) {
    Executor.execute(StdArrayIO.class, args);

    // read and print an array of doubles
    final var a = StdArrayIO.readDouble1D();
    StdArrayIO.print(a);
    StdOut.println();

    // read and print a matrix of doubles
    final var b = StdArrayIO.readDouble2D();
    StdArrayIO.print(b);
    StdOut.println();

    // read and print a matrix of doubles
    final var d = StdArrayIO.readBoolean2D();
    StdArrayIO.print(d);
    StdOut.println();
  }
}
