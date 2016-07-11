package com.github.mdssjc.algorithms.assignments.loops;

import static com.github.mdssjc.algorithms.utils.Executor.convert;
import static com.github.mdssjc.algorithms.utils.Executor.execute;

/**
 * Simulator: Creative Programming Assignments*.
 * </p>
 * Assignment: Conditionals & Loops
 * Description: Write five short Java programs to gain practice with loops,
 * conditionals, and arrays
 * Concepts: conditionals, loops and arrays
 * Difficulty: 1
 * 
 * @author mdssjc (Marcelo dos Santos)
 */
public class Simulator {

  public static void main(String[] args) {
    // Bits
    System.out.println("Bits");
    execute(Bits::main,
        convert(0), convert(1), convert(2), convert(4),
        convert(8), convert(16), convert(1000), convert(-23));

    // Noon snooze
    System.out.println("Noon snooze");
  }
}
