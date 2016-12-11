package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 20.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( "0" )
@TestDrive( "1" )
@TestDrive( "2" )
@TestDrive( "3" )
@TestDrive( "4" )
public class Ex20 {

  public static void main(final String[] args) {
    Executor.execute(Ex20.class, args);

    final QueueEx20<String> queue = new QueueEx20<>();
    queue.enqueue("A");
    queue.enqueue("B");
    queue.enqueue("C");

    queue.delete(Integer.parseInt(args[0]));

    for (final String s : queue) {
      StdOut.print(queue.dequeue() + " ");
    }
    StdOut.println();
  }
}
