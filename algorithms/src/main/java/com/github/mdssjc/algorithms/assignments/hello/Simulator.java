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
  }
}
