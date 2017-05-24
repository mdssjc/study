package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 1.1.4.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex4 {

  public static void main(final String[] args) {
    Executor.execute(Ex4.class, args);

    StdOut.println("a. if (a > b) then c = 0; -> syntax error");
    StdOut.println("b. if a > b { c = 0; } -> syntax error");
    StdOut.println("c. if (a > b) c = 0; -> ok");
    StdOut.println("d. if (a > b) c = 0 else b = 0; -> syntax error");
  }
}
