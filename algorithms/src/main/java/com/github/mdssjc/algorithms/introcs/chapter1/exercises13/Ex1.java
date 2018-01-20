package com.github.mdssjc.algorithms.introcs.chapter1.exercises13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Exercise 1.3.1.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"1", "1", "1"})
@TestDrive({"1", "2", "3"})
public class Ex1 {

  public static void main(final String[] args) {
    Executor.execute(Ex1.class, args);

    final int n1 = Integer.parseInt(args[0]);
    final int n2 = Integer.parseInt(args[1]);
    final int n3 = Integer.parseInt(args[2]);

    if (n1 == n2 && n2 == n3) {
      System.out.println("equal");
    } else {
      System.out.println("not equal");
    }
  }
}
