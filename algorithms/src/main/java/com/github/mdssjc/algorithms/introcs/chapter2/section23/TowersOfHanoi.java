package com.github.mdssjc.algorithms.introcs.chapter2.section23;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 2.3.2 Towers of Hanoi.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("1")
@TestDrive("2")
@TestDrive("3")
@TestDrive("4")
public class TowersOfHanoi {

  public static void moves(final int n, final boolean left) {
    if (n == 0) {
      return;
    }
    moves(n - 1, !left);
    if (left) {
      StdOut.println(n + " left");
    } else {
      StdOut.println(n + " right");
    }
    moves(n - 1, !left);
  }

  public static void main(final String[] args) {
    Executor.execute(TowersOfHanoi.class, args);

    final int n = Integer.parseInt(args[0]);
    moves(n, true);
  }
}
