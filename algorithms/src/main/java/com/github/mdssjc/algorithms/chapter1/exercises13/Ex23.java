package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 23.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex23 {

  public static void main(final String[] args) {
    Executor.execute(Ex23.class, args);

    StdOut.println("When it comes time to update t.next, x.next is no longer the original node following x, but is instead t itself!");
  }
}
