package com.github.mdssjc.algorithms.assignments.loops;

import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Simulator: Assignments.
 * </p>
 * Assignment: Conditionals & Loops
 * Concepts: Conditionals, Loops and Arrays
 * Difficulty: 1
 *
 * @author Marcelo dos Santos
 *
 */
public class Simulator {

  // TODO: Completar os exercícios
  public static void main(final String[] args) {
    // Boolean and integer variables
    Executor.execute(Ordered.class, "Boolean and integer variables");

    // Type conversion and conditionals
    Executor.execute(RGBtoCMYK.class, "Type conversion and conditionals");

    // Bits
    Executor.execute(Bits.class, "Bits");

    // Noon snooze
    System.out.println("Noon snooze");
  }
}
