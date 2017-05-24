package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 1.1.1.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex1 {

  public static void main(final String[] args) {
    Executor.execute(Ex1.class, args);

    StdOut.printf(
        "a. ( 0 + 15 ) / 2 -> %d%n",
        (0 + 15) / 2);

    StdOut.printf(
        "b. 2.0e-6 * 100000000.1 -> %f%n",
        2.0E-6 * 100000000.1);

    StdOut.printf(
        "c. true && false || true && true -> %s%n",
        true && false || true && true);
  }
}
