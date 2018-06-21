package com.github.mdssjc.algorithms.chapter1;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Random numbers in a given range.
 * <p>
 * Compilation:  javac RandomSeq.java
 * Execution:    java RandomSeq n lo hi
 * Dependencies: StdOut.java
 * <p>
 * Prints N numbers between lo and hi.
 * <p>
 * % java RandomSeq 5 100.0 200.0
 * 123.43
 * 153.13
 * 144.38
 * 155.18
 * 104.02
 *
 * @author Marcelo dos Santos
 *
 */

/**
 *  The {@code RandomSeq} class is a client that prints out a pseudorandom
 *  sequence of real numbers in a given range.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/11model">Section 1.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
@TestDrive({"5", "100.0", "200.0"})
public class RandomSeq {

  private RandomSeq() {
  }

  /**
   * Reads in two command-line arguments lo and hi and prints n uniformly
   * random real numbers in [lo, hi) to standard output.
   *
   * @param args the command-line arguments
   */
  public static void main(final String[] args) {
    Executor.execute(RandomSeq.class, args);

    final var n = Integer.parseInt(args[0]);

    if (args.length == 1) {
      for (var i = 0; i < n; i++) {
        final var x = StdRandom.uniform();
        StdOut.println(x);
      }
    } else if (args.length == 3) {
      final var lo = Double.parseDouble(args[1]);
      final var hi = Double.parseDouble(args[2]);

      for (var i = 0; i < n; i++) {
        final var x = StdRandom.uniform(lo, hi);
        StdOut.printf("%.2f%n", x);
      }
    } else {
      throw new IllegalArgumentException("Invalid number of arguments");
    }
  }
}
