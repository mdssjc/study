package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.queue.concrete.ResizingArrayQueue;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 15.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( value = "3", input = "a b c d e f" )
public class Ex15 {

  public static void main(final String[] args) {
    Executor.execute(Ex15.class, args);

    final ResizingArrayQueue<String> queue = new ResizingArrayQueue<>();
    while (!StdIn.isEmpty()) {
      queue.enqueue(StdIn.readString());
    }

    final int times = Integer.parseInt(args[0]);
    for (int i = 1; i < times; i++) {
      queue.dequeue();
    }

    StdOut.println(queue.dequeue());
  }
}
