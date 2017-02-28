package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 19.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex19 {

  public static void main(final String[] args) {
    Executor.execute(Ex19.class, args);

    for (int n = 0; n < 100; n++) {
      StdOut.println(n + " " + Fibonacci.f(n));
    }
  }
}
