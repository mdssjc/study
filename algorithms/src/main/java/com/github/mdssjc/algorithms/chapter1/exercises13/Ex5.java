package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.stack.Stack;
import com.github.mdssjc.algorithms.datastructure.stack.concrete.StackLinkedList;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 5.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( "50" )
public class Ex5 {

  public static void main(final String[] args) {
    Executor.execute(Ex5.class, args);

    final Stack<Integer> stack = new StackLinkedList<>();
    int n = Integer.parseInt(args[0]);

    while (n > 0) {
      stack.push(n % 2);
      n = n / 2;
    }

    for (final int d : stack) {
      StdOut.print(d);
    }
  }
}
