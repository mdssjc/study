package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 2.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex2 {

  public static void main(final String[] args) {
    Executor.execute(Ex2.class, args);

    StdOut.println((1 + 2.236) / 2); // double
    StdOut.println(1 + 2 + 3 + 4.0); // double
    StdOut.println(4.1 >= 4); // boolean
    StdOut.println(1 + 2 + "3"); // String
  }
}
