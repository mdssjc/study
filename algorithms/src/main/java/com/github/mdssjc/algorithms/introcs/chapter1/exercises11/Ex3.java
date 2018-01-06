package com.github.mdssjc.algorithms.introcs.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Exercise 1.1.3.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex3 {

  public static void main(final String[] args) {
    Executor.execute(Ex3.class, args);

    System.out.println("a. Error: <identifier> expected");
    System.out.println("b. Error: <identifier> expected; Error: invalid method declaration; return type required");
    System.out.println("c. Error: cannot find symbol");
    System.out.println("d. Compile; Print Hello, World");
  }
}
