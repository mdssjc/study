package com.github.mdssjc.algorithms.chapter1.section0;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Average of a sequence of numbers.
 * <p>
 * Compilation:  javac Average.java
 * Execution:    java Average < data.txt
 * Dependencies: StdIn.java StdOut.java
 * <p>
 * Reads in a sequence of real numbers, and computes their average.
 * <p>
 * % java Average
 * 10.0 5.0 6.0
 * 3.0 7.0 32.0
 * [Ctrl-d]
 * Average is 10.5
 * <p>
 * Note [Ctrl-d] signifies the end of file on Unix.
 * On windows use [Ctrl-z].
 *
 * @author Marcelo dos Santos
 *
 */

/**
 * The {@code Average} class provides a client for reading in a sequence
 * of real numbers and printing out their average.
 * <p>
 * For additional documentation, see <a href="https://algs4.cs.princeton.edu/11model">Section
 * 1.1</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
@TestDrive(input = "10.0 5.0 6.0 3.0 7.0 32.0")
public class Average {

  private Average() {
  }

  /**
   * Reads in a sequence of real numbers from standard input and prints
   * out their average to standard output.
   *
   * @param args
   *     the command-line arguments
   */
  public static void main(final String[] args) {
    Executor.execute(Average.class, args);

    var count = 0;
    var sum = 0.0;

    while (!StdIn.isEmpty()) {
      final var value = StdIn.readDouble();
      sum += value;
      count++;
    }

    final var average = sum / count;

    StdOut.println("Average is " + average);
  }
}
