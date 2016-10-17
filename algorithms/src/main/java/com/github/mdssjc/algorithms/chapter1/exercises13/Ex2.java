package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.stack.concrete.StackLinkedList;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 2.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( input = "it was - the best - of times - - - it was - the - -" )
public class Ex2 {

  public static void main(final String[] args) {
    Executor.execute(Ex2.class, args);

    final StackLinkedList<String> stack = new StackLinkedList<>();

    while (StdIn.hasNextLine()) {
      final String s = StdIn.readString();
      if ("-".equals(s)) {
        StdOut.print(stack.pop() + " ");
      } else {
        stack.push(s);
      }
    }
  }
}
