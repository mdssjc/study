package com.github.mdssjc.algorithms.introcs.chapter1.section11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.1.1 Hello, World.
 * <p>
 * Compilation:  javac HelloWorld.java
 * Execution:    java HelloWorld
 * <p>
 * Prints "Hello, World". By tradition, this is everyone's first program.
 * <p>
 * % java HelloWorld
 * Hello, World
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class HelloWorld {

  public static void main(final String[] args) {
    Executor.execute(HelloWorld.class, args);

    // Prints "Hello, World" to the terminal window.
    System.out.println("Hello, World");
  }
}
