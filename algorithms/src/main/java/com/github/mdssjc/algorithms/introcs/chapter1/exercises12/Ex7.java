package com.github.mdssjc.algorithms.introcs.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Exercise 1.2.7.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex7 {

  public static void main(final String[] args) {
    Executor.execute(Ex7.class, args);

    System.out.println(2 + "bc");
    System.out.println(2 + 3 + "bc");
    System.out.println((2 + 3) + "bc");
    System.out.println("bc" + (2 + 3));
    System.out.println("bc" + 2 + 3);
  }
}
