package com.github.mdssjc.algorithms.chapter1.section0;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Whitelist client.
 * <p>
 * Compilation:  javac Whitelist.java
 * Execution:    java Whitelist whitelist.txt < data.txt
 * Dependencies: StaticSetOfInts.java In.java StdOut.java
 * <p>
 * Data files:   https://algs4.cs.princeton.edu/11model/tinyW.txt
 *               https://algs4.cs.princeton.edu/11model/tinyT.txt
 *               https://algs4.cs.princeton.edu/11model/largeW.txt
 *               https://algs4.cs.princeton.edu/11model/largeT.txt
 * <p>
 * Whitelist filter.
 * <p>
 * <p>
 * % java Whitelist tinyW.txt < tinyT.txt
 * 50
 * 99
 * 13
 * <p>
 * % java Whitelist largeW.txt < largeT.txt | more
 * 499569
 * 984875
 * 295754
 * 207807
 * 140925
 * 161828
 * [367,966 total values]
 *
 * @author Marcelo dos Santos
 *
 */

/**
 *  The {@code Whitelist} class provides a client for reading in
 *  a set of integers from a file; reading in a sequence of integers
 *  from standard input; and printing to standard output those
 *  integers not in the whitelist.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/12oop">Section 1.2</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
@TestDrive(value = "tinyW.txt", valueFile = true, input = "tinyT.txt", inputFile = true)
@TestDrive(value = "largeW.txt", valueFile = true, input = "largeT.txt", inputFile = true)
public class Whitelist {

  private Whitelist() {
  }

  /**
   * Reads in a sequence of integers from the whitelist file, specified as
   * a command-line argument. Reads in integers from standard input and
   * prints to standard output those integers that are not in the file.
   *
   * @param args the command-line arguments
   */
  public static void main(final String[] args) {
    Executor.execute(Whitelist.class, args);

    final var in = new In(args[0]);
    final var white = in.readAllInts();
    final var set = new StaticSETofInts(white);

    while (!StdIn.isEmpty()) {
      final var key = StdIn.readInt();
      if (!set.contains(key)) {
        StdOut.println(key);
      }
    }
  }
}
