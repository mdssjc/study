package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 1.1.3.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"123", "123", "123"})
@TestDrive({"111", "222", "333"})
public class Ex3 {

  public static void main(final String[] args) {
    Executor.execute(Ex3.class, args);

    final int value1 = Integer.parseInt(args[0]);
    final int value2 = Integer.parseInt(args[1]);
    final int value3 = Integer.parseInt(args[2]);

    if (value1 == value2 && value2 == value3) {
      StdOut.println("equal");
    } else {
      StdOut.println("not equal");
    }
  }
}
