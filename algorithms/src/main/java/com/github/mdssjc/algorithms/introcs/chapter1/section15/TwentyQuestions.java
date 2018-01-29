package com.github.mdssjc.algorithms.introcs.chapter1.section15;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Program 1.5.2 Interactive user input.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class TwentyQuestions {

  public static void main(final String[] args) {
    Executor.execute(TwentyQuestions.class, args);

    final int secret = 1 + (int) (Math.random() * 1000000);
    StdOut.print("I'm thinking of a number ");
    StdOut.println("between 1 and 1,000,000");

    int guess = 0;
    while (guess != secret) {
      StdOut.print("What's your guess? ");
      guess = StdIn.readInt();
      if (guess == secret) {
        StdOut.println("You win!");
      }
      if (guess < secret) {
        StdOut.println("Too low ");
      }
      if (guess > secret) {
        StdOut.println("Too high");
      }
    }
  }
}
