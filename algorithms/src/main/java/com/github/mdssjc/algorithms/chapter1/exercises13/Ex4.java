package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 4.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( value = "True", input = "[ ( ) ] { } { [ ( ) ( ) ] ( ) }" )
@TestDrive( value = "False", input = "[ ( ] )" )
public class Ex4 {

  public static void main(final String[] args) {
    Executor.execute(Ex4.class, args);

    final Parentheses typeChecker = new Parentheses();

    while (StdIn.hasNextLine()) {
      final String s = StdIn.readString();
      typeChecker.add(s);
    }

    if (typeChecker.result()) {
      StdOut.println("OK " + args[0]);
    } else {
      StdOut.println("Error " + args[0]);
    }
  }
}
