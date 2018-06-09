package com.github.mdssjc.algorithms.introcs.chapter4.section42;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.2.1 Binary search (20 questions).
 * <p>
 * Compilation:  javac Questions.java
 * Execution:    java Questions k
 * Dependencies  StdIn.java
 * <p>
 * This code uses binary search to play the game of twenty questions.
 * It takes an integer command-line argument k, asks you to think of a
 * number between 0 and n-1, where n = 2^k, and always guesses the answer
 * with n questions.
 * <p>
 * %  java Questions 7
 * Think of an integer between 0 and 127
 * Is it less than 64?  false
 * Is it less than 96?  true
 * Is it less than 80?  true
 * Is it less than 72?  false
 * Is it less than 76?  false
 * Is it less than 78?  true
 * Is it less than 77?  false
 * Your number is 77
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = "7", input = {"false", "true", "true", "false", "false", "true", "false"})
public class Questions {

  public static int search(final int lo, final int hi) {
    if ((hi - lo) == 1) {
      return lo;
    }
    final var mid = lo + (hi - lo) / 2;
    StdOut.printf("Is it less than %d?  ", mid);
    if (StdIn.readBoolean()) {
      return search(lo, mid);
    } else {
      return search(mid, hi);
    }
  }

  public static void main(final String[] args) {
    Executor.execute(Questions.class, args);

    final var k = Integer.parseInt(args[0]);
    final var n = (int) Math.pow(2, k);
    StdOut.printf("Think of an integer between %d and %d%n", 0, n - 1);
    final var secret = search(0, n);
    StdOut.printf("Your number is %d%n", secret);
  }
}
