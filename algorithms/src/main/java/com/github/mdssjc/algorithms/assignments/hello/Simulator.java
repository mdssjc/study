package com.github.mdssjc.algorithms.assignments.hello;

import static com.github.mdssjc.algorithms.utils.MainUtils.execute;
import static com.github.mdssjc.algorithms.utils.MainUtils.toXS;

/**
 * Simulator: Creative Programming Assignments*.
 * </p>
 * Assignment: Hello, World
 * Description: Install a Java programming environment; write five short Java
 * programs; and submit them using our submission system
 * Concepts: Basic
 * Difficulty: 1
 * 
 * @author mdssjc (Marcelo dos Santos)
 */
public class Simulator {

  /**
   * Simulator: entry point.
   * 
   * @param args
   *          Not used
   */
  @SuppressWarnings("boxing")
  public static void main(final String[] args) {
    // Hello, World
    System.out.println("Hello, World");
    execute(HelloWorld::main);

    // Strings and Command-line Arguments
    System.out.println("Strings and Command-line Arguments");
    execute(HiFour::main,
        toXS("Alice", "Bob", "Carol", "Dave"),
        toXS("Alejandro", "Bahati", "Chandra", "Deshi"));

    // Integers and Booleans
    System.out.println("Integers and Booleans");
    execute(Ordered::main,
        toXS(10, 17, 49),
        toXS(49, 17, 10),
        toXS(10, 49, 17));

    // Floating-point Numbers and the Math Library
    System.out.println("Floating-point Numbers and the Math Library");
    execute(GreatCircle::main,
        toXS(40.35, 74.65, 48.87, -2.33),
        toXS(48.87, -2.33, 40.35, 74.65));

    // Type conversion
    System.out.println("Type conversion");
    execute(RGBtoCMYK::main,
        toXS(75, 0, 130),
        toXS(255, 143, 0));
  }
}
