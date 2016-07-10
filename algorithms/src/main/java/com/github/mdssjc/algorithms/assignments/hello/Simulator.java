package com.github.mdssjc.algorithms.assignments.hello;

/**
 * Simulator: Creative Programming Assignments*
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

  public static void main(String[] args) {
    // Hello, World
    HelloWorld.main(new String[] {});

    // Strings and Command-line Arguments
    String[][] inputs1 = {
        { "Alice", "Bob", "Carol", "Dave" },
        { "Alejandro", "Bahati", "Chandra", "Deshi" }
    };
    for (String[] input : inputs1) {
      HiFour.main(input);
    }

    // Integers and Booleans
    String[][] inputs2 = {
        { "10", "17", "49" },
        { "49", "17", "10" },
        { "10", "49", "17" }
    };
    for (String[] input : inputs2) {
      Ordered.main(input);
    }

    // Floating-point Numbers and the Math Library
    String[][] inputs3 = {
        { "40.35", "74.65", "48.87", "-2.33" },
        { "48.87", "-2.33", "40.35", "74.65" }
    };
    for (String[] input : inputs3) {
      GreatCircle.main(input);
    }

    // Type conversion
    String[][] inputs4 = {
        { "75", "0", "130" },
        { "255", "143", "0" }
    };
    for (String[] input : inputs4) {
      RGBtoCMYK.main(input);
    }
  }
}
