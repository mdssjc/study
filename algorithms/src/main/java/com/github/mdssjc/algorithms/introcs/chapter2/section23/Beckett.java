package com.github.mdssjc.algorithms.introcs.chapter2.section23;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 2.3.3 Gray code.
 * <p>
 * Compilation:  javac Beckett.java
 * Execution:    java Beckett n
 * <p>
 * Prints instructions for a Beckett play with n actors.
 * <p>
 * % java Beckett 1
 * enter 1
 * <p>
 * % java Beckett 2
 * enter 1
 * enter 2
 * exit  1
 * <p>
 * % java Beckett 3
 * enter 1
 * enter 2
 * exit  1
 * enter 3
 * enter 1
 * exit  2
 * exit  1
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("1")
@TestDrive("2")
@TestDrive("3")
public class Beckett {

  public static void moves(final int n, final boolean forward) {
    if (n == 0) {
      return;
    }
    moves(n - 1, true);
    if (forward) {
      StdOut.println("enter " + n);
    } else {
      StdOut.println("exit  " + n);
    }
    moves(n - 1, false);
  }

  public static void main(final String[] args) {
    Executor.execute(Beckett.class, args);

    final var n = Integer.parseInt(args[0]);
    moves(n, true);
  }
}
