package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.queue.Queue;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 29.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex29 {

  public static void main(final String[] args) {
    Executor.execute(Ex29.class, args);

    final Queue<String> queue = new QueueCircularLinkedList<>();
    queue.enqueue("um");
    queue.enqueue("dois");
    queue.enqueue("três");

    int i = 0;
    for (final String element : queue) {
      StdOut.println(element);
      i++;
      if (i == 5) {
        break;
      }
    }

    i = 0;
    while (i < 5) {
      StdOut.println(queue.dequeue());
      i++;
    }
  }
}
