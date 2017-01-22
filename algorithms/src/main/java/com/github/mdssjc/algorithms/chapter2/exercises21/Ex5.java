package com.github.mdssjc.algorithms.chapter2.exercises21;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Exercise 5.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex5 {
  public static void main(final String[] args) {
    Executor.execute(Ex5.class, args);

    final String[] a = "A F E D C B".split(" ");
    final InsertionSortEx4 insertion = new InsertionSortEx4();
    insertion.sort(a);

    StdOut.println(Arrays.deepToString(a));
  }
}
