package com.github.mdssjc.algorithms.introcs.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Exercise 1.2.11.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex11 {

  public static void main(final String[] args) {
    Executor.execute(Ex11.class, args);

    final double a = 3.14159;

    System.out.println(a);
    System.out.println(a + 1);
    System.out.println(8 / (int) a);
    System.out.println(8 / a);
    System.out.println((int) (8 / a));
  }
}
