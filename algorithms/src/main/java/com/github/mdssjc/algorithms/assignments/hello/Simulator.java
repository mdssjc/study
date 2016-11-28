package com.github.mdssjc.algorithms.assignments.hello;

import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Simulator: Assignments.
 * </p>
 * Assignment: Hello, World
 * Concepts: Basic
 * Difficulty: 1
 *
 * @author Marcelo dos Santos
 *
 */
public class Simulator {

  public static void main(final String[] args) {
    // Hello, World
    Executor.execute(HelloWorld.class, "Hello, World");

    // Strings and Command-line Arguments
    Executor.execute(HiFour.class, "Strings and Command-line Arguments");

    // Integers
    Executor.execute(SumThree.class, "Integers");
  }
}
