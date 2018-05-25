package com.github.mdssjc.algorithms.introcs.chapter1.section11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.1.2 Using a command-line argument.
 * <p>
 * Compilation:  javac UseArgument.java
 * Execution:    java UseArgument yourname
 * <p>
 * Prints "Hi, Bob. How are you?" where "Bob" is replaced by the
 * command-line argument.
 * <p>
 * % java UseArgument Bob
 * Hi, Bob. How are you?
 * <p>
 * % java UseArgument Alice
 * Hi, Alice. How are you?
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
