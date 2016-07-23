package com.github.mdssjc.algorithms.chapter1.exercises1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 3.
 * 
 * @author Marcelo dos Santos
 *
 */
public class Ex3 {

  public static void main(final String[] args) {
    final int value1 = Integer.parseInt(args[0]);
    final int value2 = Integer.parseInt(args[1]);
    final int value3 = Integer.parseInt(args[2]);

    if (value1 == value2 && value2 == value3) {
      StdOut.println("equal");
    } else {
      StdOut.println("not equal");
    }
  }
}
