package com.github.mdssjc.algorithms.chapter1.section13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Sample Stack client.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "1 2 3 4 5")
public class Reverse {

  public static void main(final String[] args) {
    Executor.execute(Reverse.class,args);

    final Stack<Integer> stack = new Stack<>();
    while (!StdIn.isEmpty()) {
      stack.push(StdIn.readInt());
    }

    for (final int i : stack) {
      StdOut.println(i);
    }
  }
}
