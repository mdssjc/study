package com.github.mdssjc.algorithms.introcs.chapter4.section41;

import com.github.mdssjc.algorithms.introcs.chapter3.section32.Stopwatch;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.1.1 3-sum problem.
 * <p>
 * Compilation:  javac ThreeSum.java
 * Execution:    java ThreeSum < input.txt
 * java Generator n | java ThreeSum
 * Data files:   http://www.cs.princeton.edu/introcs/41analysis/8ints.txt
 *               http://www.cs.princeton.edu/introcs/41analysis/1Kints.txt
 *               http://www.cs.princeton.edu/introcs/41analysis/2Kints.txt
 *               http://www.cs.princeton.edu/introcs/41analysis/4Kints.txt
 *               http://www.cs.princeton.edu/introcs/41analysis/8Kints.txt
 *               http://www.cs.princeton.edu/introcs/41analysis/16Kints.txt
 *               http://www.cs.princeton.edu/introcs/41analysis/32Kints.txt
 *               http://www.cs.princeton.edu/introcs/41analysis/64Kints.txt
 *               http://www.cs.princeton.edu/introcs/41analysis/128Kints.txt
 * <p>
 * A program with cubic running time. Reads in n integers
 * and counts the number of triples that sum to exactly 0.
 * <p>
 * % java ThreeSum < 8ints.txt
 * 4
 * 30 -30 0
 * 30 -20 -10
 * -30 -10 40
 * -10 0 10
 * <p>
 * % java ThreeSum < 1Kints.txt
 * 0
 * <p>
 * <p>
 * Limitations
 * -----------
 * - we ignore integer overflow
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "8ints.txt", inputFile = true)
@TestDrive(input = "1Kints.txt", inputFile = true)
public class ThreeSum {

  public static void printAll(final int[] a) {
    final var n = a.length;
    for (var i = 0; i < n; i++) {
      for (var j = i + 1; j < n; j++) {
        for (var k = j + 1; k < n; k++) {
          if (a[i] + a[j] + a[k] == 0) {
            StdOut.println(a[i] + " " + a[j] + " " + a[k]);
          }
        }
      }
    }
  }

  public static int count(final int[] a) {
    final var n = a.length;
    var count = 0;
    for (var i = 0; i < n; i++) {
      for (var j = i + 1; j < n; j++) {
        for (var k = j + 1; k < n; k++) {
          if (a[i] + a[j] + a[k] == 0) {
            count++;
          }
        }
      }
    }
    return count;
  }

  public static void main(final String[] args) {
    Executor.execute(ThreeSum.class, args);

    final var a = StdIn.readAllInts();
    final var timer = new Stopwatch();
    final var count = count(a);
    StdOut.println(count);
    printAll(a);
    StdOut.println("elapsed time = " + timer.elapsedTime());
  }
}
