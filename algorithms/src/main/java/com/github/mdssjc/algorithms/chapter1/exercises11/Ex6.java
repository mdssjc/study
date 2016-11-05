package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 6.
 * 
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex6 {

  public static void main(final String[] args) {
    Executor.execute(Ex6.class, args);

    // Fibonacci
    int f = 0;
    int g = 1;

    for (int i = 0; i <= 15; i++) {
      StdOut.println(f);
      f = f + g;
      g = f - g;
    }
  }
}
