package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.queue.concrete.QueueLinkedList;
import com.github.mdssjc.algorithms.datastructure.stack.concrete.StackLinkedList;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 6.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( input = "a b c d e f" )
public class Ex6 {

  public static void main(final String[] args) {
    Executor.execute(Ex6.class, args);

    final QueueLinkedList<String> q = new QueueLinkedList<>();
    final StackLinkedList<String> stack = new StackLinkedList<>();

    while (StdIn.hasNextLine()) {
      q.enqueue(StdIn.readString());
    }

    while (!q.isEmpty()) {
      stack.push(q.dequeue());
    }

    while (!stack.isEmpty()) {
      q.enqueue(stack.pop());
    }

    for (final String s : q) {
      StdOut.print(s);
    }
  }
}
