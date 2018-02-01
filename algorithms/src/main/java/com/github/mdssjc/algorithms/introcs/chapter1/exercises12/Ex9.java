package com.github.mdssjc.algorithms.introcs.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Exercise 1.2.9.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex9 {

  public static void main(final String[] args) {
    Executor.execute(Ex9.class, args);

    System.out.println('b');
    System.out.println('b' + 'c');
    System.out.println((char) ('a' + 4));
  }
}
