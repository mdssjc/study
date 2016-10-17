package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 10.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( value = {"( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )"} )
public class Ex10 {

  public static void main(final String[] args) {
    Executor.execute(Ex10.class, args);

    final String postfix = InfixToPostfix.convert(args[0]);
    StdOut.println(postfix);
  }
}