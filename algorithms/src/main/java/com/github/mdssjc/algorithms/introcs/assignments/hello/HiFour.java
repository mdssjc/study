package com.github.mdssjc.algorithms.introcs.assignments.hello;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Assignment 0: Strings and command-line arguments.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"Alice", "Bob", "Carol", "Dave"})
@TestDrive({"Alejandro", "Bahati", "Chandra", "Deshi"})
public class HiFour {

  public static void main(final String[] args) {
    Executor.execute(HiFour.class, args);

    StdOut.printf("Hi %s, %s, %s, and %s.%n",
                  args[3], args[2], args[1], args[0]);
  }
}
