package com.github.mdssjc.algorithms.introcs.chapter1.section11;

import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Simulator Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Simulator {

  public static void main(final String[] args) {
    Executor.execute(HelloWorld.class, "Program 1.1.1 Hello, World");
    Executor.execute(UseArgument.class, "Program 1.1.2 Using a command-line argument");
  }
}
