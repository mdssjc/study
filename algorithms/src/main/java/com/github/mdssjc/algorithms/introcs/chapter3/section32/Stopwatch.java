package com.github.mdssjc.algorithms.introcs.chapter3.section32;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 3.2.2 Stopwatch.
 * <p>
 * Compilation:  javac Stopwatch.java
 * Execution:    java Stopwatch n
 * Dependencies: none
 * <p>
 * A utility class to measure the running time (wall clock) of a program.
 * <p>
 * % java8 Stopwatch 100000000
 * 6.666667e+11  0.5820 seconds
 * 6.666667e+11  8.4530 seconds
 *
 * @author Marcelo dos Santos
 */

/**
 *  The {@code Stopwatch} data type is for measuring
 *  the time that elapses between the start and end of a
 *  programming task (wall-clock time).
 *
 *  See {@link edu.princeton.cs.introcs.StopwatchCPU} for a version that measures CPU time.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
@TestDrive("100000000")
public class Stopwatch {

  private final long start;

  /**
   * Initializes a new stopwatch.
   */
  public Stopwatch() {
    this.start = System.currentTimeMillis();
  }

  /**
   * Returns the elapsed CPU time (in seconds) since the stopwatch was created.
   *
   * @return elapsed CPU time (in seconds) since the stopwatch was created
   */
  public double elapsedTime() {
    final var now = System.currentTimeMillis();
    return (now - this.start) / 1000.0;
  }

  /**
   * Unit tests the {@code Stopwatch} data type.
   * Takes a command-line argument {@code n} and computes the
   * sum of the square roots of the first {@code n} positive integers,
   * first using {@code Math.sqrt()}, then using {@code Math.pow()}.
   * It prints to standard output the sum and the amount of time to
   * compute the sum. Note that the discrete sum can be approximated by
   * an integral - the sum should be approximately 2/3 * (n^(3/2) - 1).
   *
   * @param args
   *     the command-line arguments
   */
  public static void main(final String[] args) {
    Executor.execute(Stopwatch.class, args);

    final var n = Integer.parseInt(args[0]);

    final var timer1 = new Stopwatch();
    var sum1 = 0.0;
    for (var i = 1; i <= n; i++) {
      sum1 += Math.sqrt(i);
    }
    final var time1 = timer1.elapsedTime();
    StdOut.printf("%e (%.2f seconds)\n", sum1, time1);

    final var timer2 = new Stopwatch();
    var sum2 = 0.0;
    for (var i = 1; i <= n; i++) {
      sum2 += Math.pow(i, 0.5);
    }
    final var time2 = timer2.elapsedTime();
    StdOut.printf("%e (%.2f seconds)\n", sum2, time2);
  }
}
