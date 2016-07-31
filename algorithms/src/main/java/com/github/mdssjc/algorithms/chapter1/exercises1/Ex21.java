package com.github.mdssjc.algorithms.chapter1.exercises1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 21.
 * 
 * @author Marcelo dos Santos
 *
 */
public class Ex21 {

  public static void main(final String[] args) {
    StdOut.println("Name | Value 1 | Value 2 | Result");

    while (StdIn.hasNextLine()) {
      final String[] xs = StdIn.readLine()
        .split(" ");

      final String name = xs[0];
      final int value1 = Integer.parseInt(xs[1]);
      final int value2 = Integer.parseInt(xs[2]);
      final double result = (double) (value1) / value2;

      StdOut.printf("%s | %d | %d | %.3f%n", name, value1, value2, result);
    }
  }
}
