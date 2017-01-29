package com.github.mdssjc.algorithms.chapter2.exercises22;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 5.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex5 {

  public static void main(final String[] args) {
    Executor.execute(Ex5.class, args);

    StdOut.println("Top-down mergesort: 2, 3, 2, 5, 2, 3, 2, 5, 10, 2, 3, 2, 5, 2, 3, 2, 5, 10, 20, 2, 3, 2, 5, 2, 3, 2, 5, 10, 2, 3, 2, 5, 2, 2, 4, 9, 19, 39.");
    StdOut.println("Bottom-up mergesort: 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 4, 4, 4, 4, 4, 4, 3, 8, 8, 8, 8, 7, 16, 16, 32, 39.");
  }
}
