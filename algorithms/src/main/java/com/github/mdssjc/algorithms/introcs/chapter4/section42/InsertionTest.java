package com.github.mdssjc.algorithms.introcs.chapter4.section42;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.Stopwatch;

/**
 * Program 4.2.5 Doubling test for insertion sort.
 * <p>
 * Compilation:  javac InsertionTest.java
 * Execution:    java InsertionTest 10
 * <p>
 * The method timeTrials() runs InsertionSort.sort() for arrays of random
 * double values. The first argument is the number of trials; the second
 * argument is the length of the array. Multiple trials produce more
 * accurate results because insertion sort's running time depends on
 * the input and various system effects.
 * <p>
 * % java InsertionTest 10
 *  1024 1.89
 *  2048 5.00
 *  4096 3.58
 *  8192 4.09
 * 16384 4.83
 * 32768 3.96
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("10")
public class InsertionTest {

  public static double timeTrials(final int n, final int trials) {
    final var a = new Double[n];
    double total = 0;
    for (var t = 0; t < trials; t++) {
      for (var i = 0; i < n; i++) {
        a[i] = StdRandom.uniform(0.0, 1.0);
      }
      final var timer = new Stopwatch();
      Insertion.sort(a);
      total += timer.elapsedTime();
    }
    return total;
  }

  public static void main(final String[] args) {
    Executor.execute(InsertionTest.class, args);

    final var trials = Integer.parseInt(args[0]);
    var previous = timeTrials(512, trials);
    for (var n = 1024; true; n += n) {
      final var current = timeTrials(n, trials);
      StdOut.printf("%7d %4.2f%n", n, current / previous);
      previous = current;
    }
  }
}
