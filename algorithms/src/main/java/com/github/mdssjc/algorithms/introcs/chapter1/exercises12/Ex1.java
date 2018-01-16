package com.github.mdssjc.algorithms.introcs.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Exercise 1.1.1.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex1 {

  public static void main(final String[] args) {
    Executor.execute(Ex1.class, args);

    int a = 2;
    int b = 3;

    final int t = a; b = t; a = b;

    System.out.printf("a = %d and b = %d%n", a, b);
  }
}
