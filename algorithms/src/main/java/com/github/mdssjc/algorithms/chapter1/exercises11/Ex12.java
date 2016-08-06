package com.github.mdssjc.algorithms.chapter1.exercises11;

/**
 * Exercício 12.
 * 
 * @author Marcelo dos Santos
 *
 */
public class Ex12 {

  public static void main(final String[] args) {
    final int[] a = new int[10];
    for (int i = 0; i < 10; i++) {
      a[i] = 9 - i;
    }
    for (int i = 0; i < 10; i++) {
      a[i] = a[a[i]];
    }
    for (int i = 0; i < 10; i++) {
      System.out.println(i);
    }
    for (int i = 0; i < 10; i++) {
      System.out.println(a[i]);
    }
  }
}
