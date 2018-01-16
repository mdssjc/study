package com.github.mdssjc.algorithms.introcs.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Exercise 1.2.4.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex4 {

  public static void main(final String[] args) {
    Executor.execute(Ex4.class, args);

    final int a = 2;
    final int b = 2;

    final boolean result = !(a < b) && !(a > b); // a == b

    System.out.println(result);
  }
}
