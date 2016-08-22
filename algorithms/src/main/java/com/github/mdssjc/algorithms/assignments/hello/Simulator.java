package com.github.mdssjc.algorithms.assignments.hello;

import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Simulator: Creative Programming Assignments*.
 * </p>
 * Assignment: Hello, World
 * Description: Install a Java programming environment; write five short Java
 * programs; and submit them using our submission system
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

    // Integers and Booleans
    Executor.execute(Ordered.class, "Integers and Booleans");

    // Floating-point Numbers and the Math Library
    Executor.execute(GreatCircle.class,
        "Floating-point Numbers and the Math Library");

    // Type conversion
    Executor.execute(RGBtoCMYK.class, "Type conversion");
  }
}
