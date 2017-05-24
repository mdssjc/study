package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 1.1.7.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex7 {

  public static void main(final String[] args) {
    Executor.execute(Ex7.class, args);

    optionA(); // square root
    optionB(); // sum [1 | i <- [1..(1000 - 1)], x <- [0..(i - 1)]]
    optionC(); // sum [1 | i <- [1..(log(1000)/log(2))], x <- [0..(1000 - 1)]]
  }

  private static void optionA() {
    double t = 9.0;
    while (Math.abs(t - 9.0 / t) > .001) {
      t = (9.0 / t + t) / 2.0;
    }
    StdOut.printf("%.5f%n", t);
  }

  private static void optionB() {
    int sum = 0;
    for (int i = 1; i < 1000; i++) {
      for (int j = 0; j < i; j++) {
        sum++;
      }
    }
    StdOut.println(sum);
  }

  private static void optionC() {
    int sum = 0;
    for (int i = 1; i < 1000; i *= 2) {
      for (int j = 0; j < 1000; j++) {
        sum++;
      }
    }
    StdOut.println(sum);
  }
}
