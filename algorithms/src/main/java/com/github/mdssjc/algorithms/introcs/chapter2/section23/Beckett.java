package com.github.mdssjc.algorithms.introcs.chapter2.section23;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 2.3.3 Gray code.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("1")
@TestDrive("2")
@TestDrive("3")
@TestDrive("4")
public class Beckett {

  public static void moves(final int n, final boolean enter) {
    if (n == 0) {
      return;
    }
    moves(n - 1, true);
    if (enter) {
      StdOut.println("enter " + n);
    } else {
      StdOut.println("exit " + n);
    }
    moves(n - 1, false);
  }

  public static void main(final String[] args) {
    Executor.execute(Beckett.class, args);

    final int n = Integer.parseInt(args[0]);
    moves(n, true);
  }
}
