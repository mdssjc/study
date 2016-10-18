package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

/**
 * Exercício 12.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( input = "a b c d e f" )
public class Ex12 {

  public static void main(final String[] args) {
    Executor.execute(Ex12.class, args);

    final Stack<String> stackA = new Stack<>();
    while (!StdIn.isEmpty()) {
      stackA.push(StdIn.readString());
    }
    final Stack<String> stackB = copy(stackA);

    final StringBuilder resultA = new StringBuilder();
    final StringBuilder resultB = new StringBuilder();

    for (final String s : stackA) {
      resultA.append(s);
    }
    for (final String s : stackB) {
      resultB.append(s);
    }

    assert resultA.equals(resultB);
    assert resultA != resultB;
  }

  private static Stack<String> copy(final Stack<String> stack) {
    final Stack<String> tmp = new Stack<>();
    final Stack<String> copy = new Stack<>();

    for (final String s : stack) {
      tmp.push(s);
    }
    for (final String s : tmp) {
      copy.push(s);
    }

    return copy;
  }
}
