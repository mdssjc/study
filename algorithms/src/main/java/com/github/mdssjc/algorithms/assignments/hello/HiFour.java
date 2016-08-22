package com.github.mdssjc.algorithms.assignments.hello;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

import edu.princeton.cs.algs4.StdOut;

@TestDrive({ "Alice", "Bob", "Carol", "Dave" })
@TestDrive({ "Alejandro", "Bahati", "Chandra", "Deshi" })
public class HiFour {

  public static void main(final String[] args) {
    Executor.execute(HiFour.class, args);

    StdOut.println(String.format("%s, %s, %s, and %s.",
        args[3], args[2], args[1], args[0]));
  }
}
