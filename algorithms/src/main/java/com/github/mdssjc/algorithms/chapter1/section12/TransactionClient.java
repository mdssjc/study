package com.github.mdssjc.algorithms.chapter1.section12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;

import java.util.Arrays;

/**
 * Transaction client.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class TransactionClient {

  public static void main(final String[] args) {
    Executor.execute(TransactionClient.class, args);

    final Transaction[] a = new Transaction[4];
    a[0] = new Transaction("Turing   6/17/1990  644.08");
    a[1] = new Transaction("Tarjan   3/26/2002 4121.85");
    a[2] = new Transaction("Knuth    6/14/1999  288.34");
    a[3] = new Transaction("Dijkstra 8/22/2007 2678.40");

    StdOut.println("Unsorted");
    for (Transaction element : a) {
      StdOut.println(element);
    }
    StdOut.println();

    StdOut.println("Sort by date");
    Arrays.sort(a, new Transaction.WhenOrder());
    for (Transaction element : a) {
      StdOut.println(element);
    }
    StdOut.println();

    StdOut.println("Sort by customer");
    Arrays.sort(a, new Transaction.WhoOrder());
    for (Transaction element : a) {
      StdOut.println(element);
    }
    StdOut.println();

    StdOut.println("Sort by amount");
    Arrays.sort(a, new Transaction.HowMuchOrder());
    for (Transaction element : a) {
      StdOut.println(element);
    }
    StdOut.println();
  }
}
