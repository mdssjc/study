package com.github.mdssjc.algorithms.chapter2.section24;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.*;

/**
 * TopM Class.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = "5", input = "tinyBatch.txt", inputFile = true)
public class TopM {

  public static void main(final String[] args) {
    Executor.execute(TopM.class, args);

    final int m = Integer.parseInt(args[0]);
    final MinPQ<Transaction> pq = new MinPQ<>(m + 1);

    while (StdIn.hasNextLine()) {
      final String s = StdIn.readLine();

      pq.insert(new Transaction(s));
      if (pq.size() > m) {
        pq.delMin();
      }
    }

    final Stack<Transaction> stack = new Stack<>();
    while (!pq.isEmpty()) {
      stack.push(pq.delMin());
    }
    for (final Transaction t : stack) {
      StdOut.println(t);
    }
  }
}
