package com.github.mdssjc.algorithms.introcs.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Exercise 1.2.10.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex10 {

  public static void main(final String[] args) {
    Executor.execute(Ex10.class, args);

    final int a = 2147483647;

    System.out.println(a);
    System.out.println(a + 1);
    System.out.println(2 - a);
    System.out.println(-2 - a);
    System.out.println(2 * a);
    System.out.println(4 * a);
  }
}
