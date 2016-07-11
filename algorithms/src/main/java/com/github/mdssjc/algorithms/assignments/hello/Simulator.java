package com.github.mdssjc.algorithms.assignments.hello;

import static com.github.mdssjc.algorithms.utils.Executor.convert;
import static com.github.mdssjc.algorithms.utils.Executor.execute;

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
    execute(HelloWorld.class);

    // Strings and Command-line Arguments
    System.out.println("Strings and Command-line Arguments");
    execute(HiFour.class,
        convert("Alice", "Bob", "Carol", "Dave"),
        convert("Alejandro", "Bahati", "Chandra", "Deshi"));

    // Integers and Booleans
    System.out.println("Integers and Booleans");
    execute(Ordered.class,
        convert(10, 17, 49),
        convert(49, 17, 10),
        convert(10, 49, 17));

    // Floating-point Numbers and the Math Library
    System.out.println("Floating-point Numbers and the Math Library");
    execute(GreatCircle.class,
        convert(40.35, 74.65, 48.87, -2.33),
        convert(48.87, -2.33, 40.35, 74.65));

    // Type conversion
    System.out.println("Type conversion");
    execute(RGBtoCMYK.class,
        convert(75, 0, 130),
        convert(255, 143, 0));
  }
}
