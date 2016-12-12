package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 7.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( input = "a b c d e f" )
public class Ex7 {

  public static void main(final String[] args) {
    Executor.execute(Ex7.class, args);

    final StackEx1_3<String> stack = new StackEx1_3<>(10);
    while (StdIn.hasNextLine()) {
      stack.push(StdIn.readString());
    }

    for (int i = 0; i < 5; i++) {
      StdOut.print(stack.peek() + " ");
    }
  }
}
