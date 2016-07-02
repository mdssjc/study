package com.github.mdssjc.algorithms.exercises.deque;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Subset.
 *
 * @author Marcelo dos Santos
 *
 */
public class Subset {

  public static void main(final String[] args) {
    final int k = Integer.parseInt(args[0]);
    final RandomizedQueue<String> rndQueue = new RandomizedQueue<>();

    while (!StdIn.isEmpty()) {
      rndQueue.enqueue(StdIn.readString());
    }

    final int total = rndQueue.size() - k;
    for (int i = 0; i < total; i++) {
      rndQueue.dequeue();
    }

    for (final String string : rndQueue) {
      StdOut.println(string);
    }
  }
}
