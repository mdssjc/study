package com.github.mdssjc.algorithms.assignments.loops;

/**
 * Simulator: Creative Programming Assignments
 * </p>
 * Assignment: Conditionals & Loops
 * Description: Binary logarithm, checkerboard pattern, random walk,
 * Gaussian distribution
 * Concepts: loops and conditionals
 * Difficulty: 1
 * 
 * @author mdssjc (Marcelo dos Santos)
 */
public class Simulator {

  public static void main(String[] args) {
    // Ordered
    String[][] inputs = {
        { "10", "17", "49" },
        { "49", "17", "10" },
        { "10", "49", "17" }
    };
    for (String[] input : inputs) {
      Ordered.main(input);
    }
  }
}
