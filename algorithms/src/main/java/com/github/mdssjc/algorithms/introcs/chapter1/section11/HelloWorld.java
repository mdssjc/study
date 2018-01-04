package com.github.mdssjc.algorithms.introcs.chapter1.section11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.1.1 Hello, World.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class HelloWorld {

  public static void main(final String[] args) {
    Executor.execute(HelloWorld.class, args);

    // Prints "Hello, World" in the terminal window.
    System.out.println("Hello, World");
  }
}
