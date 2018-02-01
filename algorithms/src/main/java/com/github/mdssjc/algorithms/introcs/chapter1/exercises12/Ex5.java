package com.github.mdssjc.algorithms.introcs.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Exercise 1.2.5.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex5 {

  public static void main(final String[] args) {
    Executor.execute(Ex5.class, args);

    System.out.printf("Exclusive or:%n%n" +
                      "T T = %b%n" +
                      "T F = %b%n" +
                      "F T = %b%n" +
                      "F F = %b%n",
                      true ^ true, true ^ false, false ^ true, false ^ false);
  }
}
