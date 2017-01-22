package com.github.mdssjc.algorithms.chapter2.exercises21;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 2.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("E A S Y Q U E S T I O N")
@TestDrive("S O R T E X A M P L E")
public class Ex2 {

  public static void main(final String[] args) {
    Executor.execute(Ex2.class, args);

    final String[] a = args[0].split(" ");

    final SelectionSortEx2 selection = new SelectionSortEx2();
    selection.sort(a);

    StdOut.printf("N: %d%nMaximum: %d%nAverage: %.2f%n",
                  a.length, selection.getMax(), selection.getAverage());
  }
}
