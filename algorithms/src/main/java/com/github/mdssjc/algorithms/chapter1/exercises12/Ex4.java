package com.github.mdssjc.algorithms.chapter1.exercises12;

import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 4.
 * 
 * @author Marcelo dos Santos
 *
 */
public class Ex4 {

  public static void main(final String[] args) {
    String string1 = "hello";
    final String string2 = string1;
    string1 = "world";
    StdOut.println(string1);
    StdOut.println(string2);
  }
}
