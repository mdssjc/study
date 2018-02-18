package com.github.mdssjc.algorithms.introcs.assignments.hello;

import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Assignment 0: Hello, World.
 *
 * @author Marcelo dos Santos
 *
 */
public class Simulator {

  public static void main(final String[] args) {
    // Hello, World
    Executor.execute(HelloWorld.class, "Hello, World");

    // Strings and command-line arguments
    Executor.execute(HiFour.class, "Strings and command-line arguments");

    // Integers and booleans
    Executor.execute(Ordered.class, "Integers and booleans");

    // Floating-point numbers and the Math library
    Executor.execute(GreatCircle.class, "Floating-point numbers and the Math library");

    // Type conversion
    Executor.execute(RGBtoCMYK.class, "Type conversion");
  }

  public static int max(int a, int b) {
    return b & ((a - b) >> 31) | a & (~(a - b) >> 31);
  }
}
