package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 8.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex8 {

  public static void main(final String[] args) {
    Executor.execute(Ex8.class, args);

    // Prints a char
    StdOut.println('b');

    // Adds the numbers representing the char and prints its result
    StdOut.println('b' + 'c');

    // Adds the numbers representing the char and prints its result in char
    StdOut.println((char) ('a' + 4));
  }
}
