package com.github.mdssjc.algorithms.introcs.chapter1.section15;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 1.5.2 Interactive user input.
 * <p>
 * Compilation:  javac TwentyQuestions.java
 * Execution:    java TwentyQuestions
 * Dependencies  StdIn.java
 * <p>
 * % java TwentyQuestions
 * I'm thinking of a number between 1 and 1,000,000
 * What's your guess? 500000
 * Too high
 * What's your guess? 250000
 * Too low
 * What's your guess? 375000
 * Too high
 * What's your guess? 312500
 * Too high
 * What's your guess? 300500
 * Too low
 * ...
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class TwentyQuestions {

  public static void main(final String[] args) {
    Executor.execute(TwentyQuestions.class, args);

    final var secret = 1 + (int) (Math.random() * 1000000);

    StdOut.print("I'm thinking of a number ");
    StdOut.println("between 1 and 1,000,000");
    var guess = 0;
    while (guess != secret) {
      StdOut.print("What's your guess? ");
      guess = StdIn.readInt();
      if (guess == secret) {
        StdOut.println("You win!");
      } else if (guess < secret) {
        StdOut.println("Too low ");
      } else if (guess > secret) {
        StdOut.println("Too high");
      }
    }
  }
}
