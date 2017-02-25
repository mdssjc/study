package com.github.mdssjc.algorithms.chapter2.exercises24;

import com.github.mdssjc.algorithms.datastructure.priority_queue.PriorityQueue;
import com.github.mdssjc.algorithms.datastructure.priority_queue.concrete.MaxPQ;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 1.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("P R I O * R * * I * T * Y * * * Q U E * * * U * E")
public class Ex1 {

  public static void main(final String[] args) {
    Executor.execute(Ex1.class, args);

    final PriorityQueue<String> pq = new MaxPQ<>();
    final String[] xs = args[0].split(" ");

    for (final String x : xs) {
      if ("*".equals(x)) {
        StdOut.print(pq.delete() + " ");
      } else {
        pq.insert(x);
      }
    }
  }
}
