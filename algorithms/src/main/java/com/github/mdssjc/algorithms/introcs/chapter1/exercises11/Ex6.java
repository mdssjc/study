package com.github.mdssjc.algorithms.introcs.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Exercise 1.1.6.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"Alice", "Bob", "Carol"})
public class Ex6 {

  public static void main(final String[] args) {
    Executor.execute(Ex6.class, args);
    UseThree.main(args);
  }
}

class UseThree {

  public static void main(final String[] args) {
    System.out.printf("Hi %s, %s, and %s.%n",
                      args[2], args[1], args[0]);
  }
}
