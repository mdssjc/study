package com.github.mdssjc.algorithms.introcs.chapter1.section11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.1.2 Using a command-line argument.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("Alice")
@TestDrive("Bob")
public class UseArgument {

  public static void main(final String[] args) {
    Executor.execute(UseArgument.class, args);

    System.out.print("Hi, ");
    System.out.print(args[0]);
    System.out.println(". How are you?");
  }
}
