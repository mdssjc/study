package com.github.mdssjc.algorithms.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

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

    final String s = "Hello World";
    s.toUpperCase();
    s.substring(6, 11);
    StdOut.println(s);
  }
}
