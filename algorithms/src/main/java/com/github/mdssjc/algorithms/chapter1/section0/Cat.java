package com.github.mdssjc.algorithms.chapter1.section0;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

/**
 * Concatenate files.
 * <p>
 * Compilation:  javac Cat.java
 * Execution:    java Cat input0.txt input1.txt ... output.txt
 * Dependencies: In.java Out.java
 * Data files:   https://algs4.cs.princeton.edu/11model/in1.txt
 *               https://algs4.cs.princeton.edu/11model/in2.txt
 * <p>
 * Reads in text files specified as the first command-line
 * arguments, concatenates them, and writes the result to
 * filename specified as the last command-line arguments.
 * <p>
 * % more in1.txt
 * This is
 * <p>
 * % more in2.txt
 * a tiny
 * test.
 * <p>
 * % java Cat in1.txt in2.txt out.txt
 * <p>
 * % more out.txt
 * This is
 * a tiny
 * test.
 *
 * @author Marcelo dos Santos
 *
 */

/**
 *  The {@code Cat} class provides a client for concatenating the results
 *  of several text files.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/11model">Section 1.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
@TestDrive(value = {"in1.txt", "in2.txt", "out.txt"}, valueFile = true)
public class Cat {

  private Cat() {
  }

  /**
   * Reads in a sequence of text files specified as the first command-line
   * arguments, concatenates them, and writes the results to the file
   * specified as the last command-line argument.
   *
   * @param args the command-line arguments
   */
  public static void main(final String[] args) {
    Executor.execute(Cat.class, args);

    final var out = new Out(args[args.length - 1]);
    for (var i = 0; i < args.length - 1; i++) {
      final var in = new In(args[i]);
      final var s = in.readAll();
      out.println(s);
      in.close();
    }
    out.close();
  }
}
