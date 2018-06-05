package com.github.mdssjc.algorithms.introcs.chapter2.section23;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 2.3.2 Towers of Hanoi.
 * <p>
 * Compilation:  javac TowersOfHanoi.java
 * Execution:    java TowersOfHanoi n
 * <p>
 * Solves the Towers of Hanoi problem on n discs. The discs are labeled
 * in increasing order of size from 1 to n.
 * <p>
 * %  java TowersOfHanoi 3
 * 1 left
 * 2 right
 * 1 left
 * 3 left
 * 1 left
 * 2 right
 * 1 left
 * <p>
 * % java TowersOfHanoi 4
 * 1 right
 * 2 left
 * 1 right
 * 3 right
 * 1 right
 * 2 left
 * 1 right
 * 4 left
 * 1 right
 * 2 left
 * 1 right
 * 3 right
 * 1 right
 * 2 left
 * 1 right
 *
 * @author Marcelo dos Santos
 *
 */
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

    final var n = Integer.parseInt(args[0]);
    moves(n, true);
  }
}
