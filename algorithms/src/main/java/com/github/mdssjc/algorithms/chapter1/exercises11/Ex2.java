package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 1.1.2.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex2 {

  public static void main(final String[] args) {
    Executor.execute(Ex2.class, args);

    final double a = (1 + 2.236) / 2;
    StdOut.printf("a. double | %f%n", a);

    final double b = 1 + 2 + 3 + 4.0;
    StdOut.printf("b. double | %f%n", b);

    final boolean c = 4.1 >= 4;
    StdOut.printf("c. boolean | %s%n", c);

    final String d = 1 + 2 + "3";
    StdOut.printf("d. String | %s%n", d);
  }
}
