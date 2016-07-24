package com.github.mdssjc.algorithms.assignments.loops;

import static com.github.mdssjc.algorithms.utils.MainUtils.execute;
import static com.github.mdssjc.algorithms.utils.MainUtils.toXSS;

/**
 * Simulator: Creative Programming Assignments*.
 * </p>
 * Assignment: Conditionals & Loops
 * Description: Write five short Java programs to gain practice with loops,
 * conditionals, and arrays
 * Concepts: conditionals, loops and arrays
 * Difficulty: 1
 * 
 * @author Marcelo dos Santos
 * 
 */
public class Simulator {

  // TODO: Completar os exercícios
  public static void main(String[] args) {
    // Bits
    System.out.println("Bits");
    execute(Bits::main, toXSS(
        0, 1, 2, 4,
        8, 16, 1000, -23));

    // Noon snooze
    System.out.println("Noon snooze");
  }
}
