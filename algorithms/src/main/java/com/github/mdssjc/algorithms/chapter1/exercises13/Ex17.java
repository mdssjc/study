package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.queue.concrete.ResizingArrayQueue;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;

/**
 * Exercício 17.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( input = {"Turing 5/22/1939 11.99\n", "Santos 7/10/1984 11.35\n", "Sedgewick 10/15/2016 25.99\n"} )
public class Ex17 {

  public static void main(final String[] args) {
    Executor.execute(Ex17.class, args);

    for (final Transaction transaction : readTransactions()) {
      StdOut.println(transaction.toString());
    }
  }

  public static Transaction[] readTransactions() {
    final ResizingArrayQueue<Transaction> transactions = new ResizingArrayQueue<>();
    while (!StdIn.isEmpty()) {
      transactions.enqueue(new Transaction(StdIn.readLine()));
    }

    final int n = transactions.size();
    final Transaction[] t = new Transaction[n];
    for (int i = 0; i < n; i++) {
      t[i] = transactions.dequeue();
    }
    return t;
  }
}
