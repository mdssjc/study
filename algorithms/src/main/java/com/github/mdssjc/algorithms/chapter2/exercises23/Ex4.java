package com.github.mdssjc.algorithms.chapter2.exercises23;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.Monitor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 4.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex4 {

  public static void main(final String[] args) {
    Executor.execute(Ex4.class, args);

    final Monitor monitor = new Monitor("m4");
    final Integer[][] xss = {
        {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
        {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, // worst
        {0, 9, 1, 8, 2, 7, 3, 6, 4, 5}, // best
        {9, 0, 8, 1, 7, 2, 6, 3, 5, 4}, // best
        {0, 1, 2, 3, 4, 9, 8, 7, 6, 5},
        {9, 8, 7, 6, 5, 0, 1, 2, 3, 4}
    };

    for (int i = 0; i < xss.length; i++) {
      StdOut.printf("Loop %d:%n", i);
      final QuickSortMonitor quick = new QuickSortMonitor(monitor);
      quick.sort(xss[i]);
    }
  }
}
