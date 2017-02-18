package com.github.mdssjc.algorithms.datastructure.priority_queue;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.*;

/**
 * Cliente TopM.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = "5", input = "tinyBatch.txt", inputFile = true)
public class TopM {

  public static void main(final String[] args) {
    Executor.execute(TopM.class, args);

    // Print the top M lines in the input stream.
    final int M = Integer.parseInt(args[0]);
    final MinPQ<Transaction> pq = new MinPQ<>(M + 1);

    while (StdIn.hasNextLine()) {
      // Create an entry from the next line and put on the PQ.
      final String s = StdIn.readLine();

      pq.insert(new Transaction(s));
      if (pq.size() > M) {
        pq.delMin(); // Remove minimum if M+1 entries on the PQ.
      }
    }

    // Top M entries are on the PQ.
    final Stack<Transaction> stack = new Stack<>();
    while (!pq.isEmpty()) {
      stack.push(pq.delMin());
    }
    for (final Transaction t : stack) {
      StdOut.println(t);
    }
  }
}
