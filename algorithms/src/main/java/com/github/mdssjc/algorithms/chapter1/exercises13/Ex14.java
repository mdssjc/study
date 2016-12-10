package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.queue.Queue;
import com.github.mdssjc.algorithms.datastructure.queue.concrete.ResizingArrayQueue;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdIn;

/**
 * Exercise 14.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( value = "0 1 2 3 4 5", input = "0 1 2 3 4 5" )
public class Ex14 {

  public static void main(final String[] args) {
    Executor.execute(Ex14.class, args);

    final Queue<String> queue = new ResizingArrayQueue<>();

    while (!StdIn.isEmpty()) {
      queue.enqueue(StdIn.readString());
    }

    final StringBuilder sb = new StringBuilder();
    for (final String s : queue) {
      sb.append(s + " ");
    }

    assert args[0].equals(sb.toString().trim());
  }
}
