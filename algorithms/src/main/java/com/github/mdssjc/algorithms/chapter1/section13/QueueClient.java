package com.github.mdssjc.algorithms.chapter1.section13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Sample Queue client.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "1 2 3 4 5")
public class QueueClient {

  public static void main(final String[] args) {
    Executor.execute(QueueClient.class, args);

    final Queue<Integer> queue = new Queue<>();
    while (!StdIn.isEmpty()) {
      queue.enqueue(StdIn.readInt());
    }

    final int n = queue.size();
    for (int i = 0; i < n; i++) {
      StdOut.println(queue.dequeue());
    }
  }
}
