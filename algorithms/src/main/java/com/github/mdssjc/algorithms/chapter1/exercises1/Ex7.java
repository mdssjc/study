package com.github.mdssjc.algorithms.chapter1.exercises1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 7.
 * 
 * @author Marcelo dos Santos
 *
 */
public class Ex7 {

  public static void main(final String[] args) {
    optionA(); // square root
    optionB(); // sum
    optionC(); // error
  }

  private static void optionA() {
    double t = 9.0;
    while (Math.abs(t - 9.0 / t) > .001) {
      t = (9.0 / t + t) / 2.0;
    }
    StdOut.printf("%.5f\n", t);
  }

  private static void optionB() {
    int sum = 0;
    for (int i = 1; i < 5; i++) {
      for (int j = 0; j < i; j++) {
        sum++;
      }
    }
    StdOut.println(sum);
  }

  private static void optionC() {
    final int sum = 0;
    for (int i = 1; i < 1000; i *= 2) {
      // for (int j = 0; j < N; j++) {
      // sum++;
      // }
    }
    StdOut.println(sum);
  }
}
