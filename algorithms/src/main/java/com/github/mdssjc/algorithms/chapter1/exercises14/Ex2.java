package com.github.mdssjc.algorithms.chapter1.exercises14;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 2.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex2 {

  public static void main(final String[] args) {
    Executor.execute(Ex2.class, args);

    final int[] a = {2, Integer.MAX_VALUE, 1, 3, -2, 1};

    final int count = ThreeSumFixOverflow.count(a);
    StdOut.println(count);
  }
}
