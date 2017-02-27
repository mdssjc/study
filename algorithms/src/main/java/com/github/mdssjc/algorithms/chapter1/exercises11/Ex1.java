package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 1.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex1 {

  public static void main(final String[] args) {
    Executor.execute(Ex1.class, args);

    StdOut.println((0 + 15) / 2);
    StdOut.println(2.0E-6 * 100000000.1);
    StdOut.println(true && false || true && true);
  }
}
