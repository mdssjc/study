package com.github.mdssjc.algorithms.introcs.chapter2.section22;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 2.2.4 Data analysis library.
 * Program 2.2.5 Plotting data values in an array.
 * <p>
 * Compilation:  javac StdStats.java
 * Execution:    java StdStats < input.txt
 * Dependencies: StdOut.java
 * <p>
 * Library of statistical functions.
 * <p>
 * The test client reads an array of real numbers from standard
 * input, and computes the minimum, mean, maximum, and
 * standard deviation.
 * <p>
 * The functions all throw a java.lang.IllegalArgumentException
 * if the array passed in as an argument is null.
 * <p>
 * The floating-point functions all return NaN if any input is NaN.
 * <p>
 * Unlike Math.min() and Math.max(), the min() and max() functions
 * do not differentiate between -0.0 and 0.0.
 * <p>
 * % more tiny.txt
 * 5
 * 3.0 1.0 2.0 5.0 4.0
 * <p>
 * % java StdStats < tiny.txt
 *        min   1.000
 *       mean   3.000
 *        max   5.000
 *    std dev   1.581
 * <p>
 * Should these funtions use varargs instead of array arguments?
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "tiny1D.txt", inputFile = true)
/**
 *  The {@code StdStats} class provides static methods for computing
 *  statistics such as min, max, mean, sample standard deviation, and
 *  sample variance.
 *  <p>
 *  For additional documentation, see
 *  <a href="https://introcs.cs.princeton.edu/22library">Section 2.2</a> of
 *  <i>Computer Science: An Interdisciplinary Approach</i>
 *  by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public final class StdStats {

  private StdStats() {
  }

  /**
   * Returns the maximum value in the specified array.
   *
   * @param a
   *     the array
   *
   * @return the maximum value in the array {@code a[]};
   * {@code Double.NEGATIVE_INFINITY} if no such value
   */
  public static double max(final double[] a) {
    validateNotNull(a);

    var max = Double.NEGATIVE_INFINITY;
    for (var i = 0; i < a.length; i++) {
      if (Double.isNaN(a[i])) {
        return Double.NaN;
      }
      if (a[i] > max) {
        max = a[i];
      }
    }
    return max;
  }

  /**
   * Returns the maximum value in the specified subarray.
   *
   * @param a
   *     the array
   * @param lo
   *     the left endpoint of the subarray (inclusive)
   * @param hi
   *     the right endpoint of the subarray (exclusive)
   *
   * @return the maximum value in the subarray {@code a[lo..hi)};
   * {@code Double.NEGATIVE_INFINITY} if no such value
   *
   * @throws IllegalArgumentException
   *     if {@code a} is {@code null}
   * @throws IllegalArgumentException
   *     unless {@code (0 <= lo) && (lo < hi) && (hi <= a.length)}
   */
  public static double max(final double[] a, final int lo, final int hi) {
    validateNotNull(a);
    validateSubarrayIndices(lo, hi, a.length);

    var max = Double.NEGATIVE_INFINITY;
    for (var i = lo; i < hi; i++) {
      if (Double.isNaN(a[i])) {
        return Double.NaN;
      }
      if (a[i] > max) {
        max = a[i];
      }
    }
    return max;
  }

  /**
   * Returns the maximum value in the specified array.
   *
   * @param a
   *     the array
   *
   * @return the maximum value in the array {@code a[]};
   * {@code Integer.MIN_VALUE} if no such value
   */
  public static int max(final int[] a) {
    validateNotNull(a);

    var max = Integer.MIN_VALUE;
    for (var i = 0; i < a.length; i++) {
      if (a[i] > max) {
        max = a[i];
      }
    }
    return max;
  }

  /**
   * Returns the minimum value in the specified array.
   *
   * @param a
   *     the array
   *
   * @return the minimum value in the array {@code a[]};
   * {@code Double.POSITIVE_INFINITY} if no such value
   */
  public static double min(final double[] a) {
    validateNotNull(a);

    var min = Double.POSITIVE_INFINITY;
    for (var i = 0; i < a.length; i++) {
      if (Double.isNaN(a[i])) {
        return Double.NaN;
      }
      if (a[i] < min) {
        min = a[i];
      }
    }
    return min;
  }

  /**
   * Returns the minimum value in the specified subarray.
   *
   * @param a
   *     the array
   * @param lo
   *     the left endpoint of the subarray (inclusive)
   * @param hi
   *     the right endpoint of the subarray (exclusive)
   *
   * @return the maximum value in the subarray {@code a[lo..hi)};
   * {@code Double.POSITIVE_INFINITY} if no such value
   *
   * @throws IllegalArgumentException
   *     if {@code a} is {@code null}
   * @throws IllegalArgumentException
   *     unless {@code (0 <= lo) && (lo < hi) && (hi <= a.length)}
   */
  public static double min(final double[] a, final int lo, final int hi) {
    validateNotNull(a);
    validateSubarrayIndices(lo, hi, a.length);

    var min = Double.POSITIVE_INFINITY;
    for (var i = lo; i < hi; i++) {
      if (Double.isNaN(a[i])) {
        return Double.NaN;
      }
      if (a[i] < min) {
        min = a[i];
      }
    }
    return min;
  }

  /**
   * Returns the minimum value in the specified array.
   *
   * @param a
   *     the array
   *
   * @return the minimum value in the array {@code a[]};
   * {@code Integer.MAX_VALUE} if no such value
   */
  public static int min(final int[] a) {
    validateNotNull(a);

    var min = Integer.MAX_VALUE;
    for (var i = 0; i < a.length; i++) {
      if (a[i] < min) {
        min = a[i];
      }
    }
    return min;
  }

  /**
   * Returns the average value in the specified array.
   *
   * @param a
   *     the array
   *
   * @return the average value in the array {@code a[]};
   * {@code Double.NaN} if no such value
   */
  public static double mean(final double[] a) {
    validateNotNull(a);

    if (a.length == 0) {
      return Double.NaN;
    }
    final var sum = sum(a);
    return sum / a.length;
  }

  /**
   * Returns the average value in the specified subarray.
   *
   * @param a
   *     the array
   * @param lo
   *     the left endpoint of the subarray (inclusive)
   * @param hi
   *     the right endpoint of the subarray (exclusive)
   *
   * @return the average value in the subarray {@code a[lo..hi)};
   * {@code Double.NaN} if no such value
   *
   * @throws IllegalArgumentException
   *     if {@code a} is {@code null}
   * @throws IllegalArgumentException
   *     unless {@code (0 <= lo) && (lo < hi) && (hi <= a.length)}
   */
  public static double mean(final double[] a, final int lo, final int hi) {
    validateNotNull(a);
    validateSubarrayIndices(lo, hi, a.length);

    final var length = hi - lo;
    if (length == 0) {
      return Double.NaN;
    }

    final var sum = sum(a, lo, hi);
    return sum / length;
  }

  /**
   * Returns the average value in the specified array.
   *
   * @param a
   *     the array
   *
   * @return the average value in the array {@code a[]};
   * {@code Double.NaN} if no such value
   */
  public static double mean(final int[] a) {
    validateNotNull(a);

    if (a.length == 0) {
      return Double.NaN;
    }
    final var sum = sum(a);
    return 1.0 * sum / a.length;
  }

  /**
   * Returns the sample variance in the specified array.
   *
   * @param a
   *     the array
   *
   * @return the sample variance in the array {@code a[]};
   * {@code Double.NaN} if no such value
   */
  public static double var(final double[] a) {
    validateNotNull(a);

    if (a.length == 0) {
      return Double.NaN;
    }
    final var avg = mean(a);
    var sum = 0.0;
    for (var i = 0; i < a.length; i++) {
      sum += (a[i] - avg) * (a[i] - avg);
    }
    return sum / (a.length - 1);
  }

  /**
   * Returns the sample variance in the specified subarray.
   *
   * @param a
   *     the array
   * @param lo
   *     the left endpoint of the subarray (inclusive)
   * @param hi
   *     the right endpoint of the subarray (exclusive)
   *
   * @return the sample variance in the subarray {@code a[lo..hi)};
   * {@code Double.NaN} if no such value
   *
   * @throws IllegalArgumentException
   *     if {@code a} is {@code null}
   * @throws IllegalArgumentException
   *     unless {@code (0 <= lo) && (lo < hi) && (hi <= a.length)}
   */
  public static double var(final double[] a, final int lo, final int hi) {
    validateNotNull(a);
    validateSubarrayIndices(lo, hi, a.length);

    final var length = hi - lo;
    if (length == 0) {
      return Double.NaN;
    }

    final var avg = mean(a, lo, hi);
    var sum = 0.0;
    for (var i = lo; i < hi; i++) {
      sum += (a[i] - avg) * (a[i] - avg);
    }
    return sum / (length - 1);
  }

  /**
   * Returns the sample variance in the specified array.
   *
   * @param a
   *     the array
   *
   * @return the sample variance in the array {@code a[]};
   * {@code Double.NaN} if no such value
   */
  public static double var(final int[] a) {
    validateNotNull(a);
    if (a.length == 0) {
      return Double.NaN;
    }
    final var avg = mean(a);
    var sum = 0.0;
    for (var i = 0; i < a.length; i++) {
      sum += (a[i] - avg) * (a[i] - avg);
    }
    return sum / (a.length - 1);
  }

  /**
   * Returns the population variance in the specified array.
   *
   * @param a
   *     the array
   *
   * @return the population variance in the array {@code a[]};
   * {@code Double.NaN} if no such value
   */
  public static double varp(final double[] a) {
    validateNotNull(a);
    if (a.length == 0) {
      return Double.NaN;
    }
    final var avg = mean(a);
    var sum = 0.0;
    for (var i = 0; i < a.length; i++) {
      sum += (a[i] - avg) * (a[i] - avg);
    }
    return sum / a.length;
  }

  /**
   * Returns the population variance in the specified subarray.
   *
   * @param a
   *     the array
   * @param lo
   *     the left endpoint of the subarray (inclusive)
   * @param hi
   *     the right endpoint of the subarray (exclusive)
   *
   * @return the population variance in the subarray {@code a[lo..hi)};
   * {@code Double.NaN} if no such value
   *
   * @throws IllegalArgumentException
   *     if {@code a} is {@code null}
   * @throws IllegalArgumentException
   *     unless {@code (0 <= lo) && (lo < hi) && (hi <= a.length)}
   */
  public static double varp(final double[] a, final int lo, final int hi) {
    validateNotNull(a);
    validateSubarrayIndices(lo, hi, a.length);

    final var length = hi - lo;
    if (length == 0) {
      return Double.NaN;
    }

    final var avg = mean(a, lo, hi);
    var sum = 0.0;
    for (var i = lo; i < hi; i++) {
      sum += (a[i] - avg) * (a[i] - avg);
    }
    return sum / length;
  }

  /**
   * Returns the sample standard deviation in the specified array.
   *
   * @param a
   *     the array
   *
   * @return the sample standard deviation in the array {@code a[]};
   * {@code Double.NaN} if no such value
   */
  public static double stddev(final double[] a) {
    validateNotNull(a);
    return Math.sqrt(var(a));
  }

  /**
   * Returns the sample standard deviation in the specified array.
   *
   * @param a
   *     the array
   *
   * @return the sample standard deviation in the array {@code a[]};
   * {@code Double.NaN} if no such value
   */
  public static double stddev(final int[] a) {
    validateNotNull(a);
    return Math.sqrt(var(a));
  }

  /**
   * Returns the sample standard deviation in the specified subarray.
   *
   * @param a
   *     the array
   * @param lo
   *     the left endpoint of the subarray (inclusive)
   * @param hi
   *     the right endpoint of the subarray (exclusive)
   *
   * @return the sample standard deviation in the subarray {@code a[lo..hi)};
   * {@code Double.NaN} if no such value
   *
   * @throws IllegalArgumentException
   *     if {@code a} is {@code null}
   * @throws IllegalArgumentException
   *     unless {@code (0 <= lo) && (lo < hi) && (hi <= a.length)}
   */
  public static double stddev(final double[] a, final int lo, final int hi) {
    validateNotNull(a);
    validateSubarrayIndices(lo, hi, a.length);

    return Math.sqrt(var(a, lo, hi));
  }


  /**
   * Returns the population standard deviation in the specified array.
   *
   * @param a
   *     the array
   *
   * @return the population standard deviation in the array;
   * {@code Double.NaN} if no such value
   */
  public static double stddevp(final double[] a) {
    validateNotNull(a);
    return Math.sqrt(varp(a));
  }

  /**
   * Returns the population standard deviation in the specified subarray.
   *
   * @param a
   *     the array
   * @param lo
   *     the left endpoint of the subarray (inclusive)
   * @param hi
   *     the right endpoint of the subarray (exclusive)
   *
   * @return the population standard deviation in the subarray {@code a[lo..hi)};
   * {@code Double.NaN} if no such value
   *
   * @throws IllegalArgumentException
   *     if {@code a} is {@code null}
   * @throws IllegalArgumentException
   *     unless {@code (0 <= lo) && (lo < hi) && (hi <= a.length)}
   */
  public static double stddevp(final double[] a, final int lo, final int hi) {
    validateNotNull(a);
    validateSubarrayIndices(lo, hi, a.length);

    return Math.sqrt(varp(a, lo, hi));
  }

  /**
   * Returns the sum of all values in the specified array.
   *
   * @param a
   *     the array
   *
   * @return the sum of all values in the array {@code a[]};
   * {@code 0.0} if no such value
   */
  private static double sum(final double[] a) {
    validateNotNull(a);
    var sum = 0.0;
    for (var i = 0; i < a.length; i++) {
      sum += a[i];
    }
    return sum;
  }

  /**
   * Returns the sum of all values in the specified subarray.
   *
   * @param a
   *     the array
   * @param lo
   *     the left endpoint of the subarray (inclusive)
   * @param hi
   *     the right endpoint of the subarray (exclusive)
   *
   * @return the sum of all values in the subarray {@code a[lo..hi)};
   * {@code 0.0} if no such value
   *
   * @throws IllegalArgumentException
   *     if {@code a} is {@code null}
   * @throws IllegalArgumentException
   *     unless {@code (0 <= lo) && (lo < hi) && (hi <= a.length)}
   */
  private static double sum(final double[] a, final int lo, final int hi) {
    validateNotNull(a);
    validateSubarrayIndices(lo, hi, a.length);

    var sum = 0.0;
    for (var i = lo; i < hi; i++) {
      sum += a[i];
    }
    return sum;
  }

  /**
   * Returns the sum of all values in the specified array.
   *
   * @param a
   *     the array
   *
   * @return the sum of all values in the array {@code a[]};
   * {@code 0.0} if no such value
   */
  private static int sum(final int[] a) {
    validateNotNull(a);
    var sum = 0;
    for (var i = 0; i < a.length; i++) {
      sum += a[i];
    }
    return sum;
  }

  /**
   * Plots the points (0, <em>a</em><sub>0</sub>), (1, <em>a</em><sub>1</sub>),
   * ...,
   * (<em>n</em>–1, <em>a</em><sub><em>n</em>–1</sub>) to standard draw.
   *
   * @param a
   *     the array of values
   */
  public static void plotPoints(final double[] a) {
    validateNotNull(a);
    final var n = a.length;
    StdDraw.setXscale(-1, n);
    StdDraw.setPenRadius(1.0 / (3.0 * n));
    for (var i = 0; i < n; i++) {
      StdDraw.point(i, a[i]);
    }
  }

  /**
   * Plots the line segments connecting
   * (<em>i</em>, <em>a</em><sub><em>i</em></sub>) to
   * (<em>i</em>+1, <em>a</em><sub><em>i</em>+1</sub>) for
   * each <em>i</em> to standard draw.
   *
   * @param a
   *     the array of values
   */
  public static void plotLines(final double[] a) {
    validateNotNull(a);
    final var n = a.length;
    StdDraw.setXscale(-1, n);
    StdDraw.setPenRadius();
    for (var i = 1; i < n; i++) {
      StdDraw.line(i - 1, a[i - 1], i, a[i]);
    }
  }

  /**
   * Plots bars from (0, <em>a</em><sub><em>i</em></sub>) to
   * (<em>a</em><sub><em>i</em></sub>) for each <em>i</em>
   * to standard draw.
   *
   * @param a
   *     the array of values
   */
  public static void plotBars(final double[] a) {
    validateNotNull(a);
    final var n = a.length;
    StdDraw.setXscale(-1, n);
    for (var i = 0; i < n; i++) {
      StdDraw.filledRectangle(i, a[i] / 2, 0.25, a[i] / 2);
    }
  }

  // throw an IllegalArgumentException if x is null
  // (x is either of type double[] or int[])
  private static void validateNotNull(final Object x) {
    if (x == null) {
      throw new IllegalArgumentException("argument is null");
    }
  }

  // throw an exception unless 0 <= lo <= hi <= length
  private static void validateSubarrayIndices(final int lo, final int hi, final int length) {
    if (lo < 0 || hi > length || lo > hi) {
      throw new IllegalArgumentException(
          "subarray indices out of bounds: [" + lo + ", " + hi + ")");
    }
  }


  /**
   * Unit tests {@code StdStats}.
   * Convert command-line arguments to array of doubles and call various
   * methods.
   *
   * @param args
   *     the command-line arguments
   */
  public static void main(final String[] args) {
    Executor.execute(StdStats.class, args);

    final var a = StdArrayIO.readDouble1D();
    StdOut.printf("       min %10.3f%n", min(a));
    StdOut.printf("      mean %10.3f%n", mean(a));
    StdOut.printf("       max %10.3f%n", max(a));
    StdOut.printf("    stddev %10.3f%n", stddev(a));
    StdOut.printf("       var %10.3f%n", var(a));
    StdOut.printf("   stddevp %10.3f%n", stddevp(a));
    StdOut.printf("      varp %10.3f%n", varp(a));
  }
}
