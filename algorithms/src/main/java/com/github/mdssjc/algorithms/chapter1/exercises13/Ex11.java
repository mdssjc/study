package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 11.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( value = "3", input = "( ( 1 2 + ) ( ( 3 4 - ) ( 5 6 - ) * ) * )" )
public class Ex11 {

  public static void main(final String[] args) {
    Executor.execute(Ex11.class, args);

    final EvaluatePostfix eval = new EvaluatePostfix();
    while (!StdIn.isEmpty()) {
      eval.add(StdIn.readString());
    }

    final double result = eval.result();

    StdOut.println(result);
    assert result == Double.parseDouble(args[0]);
  }
}
