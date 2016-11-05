package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 8.
 * 
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex8 {

  public static void main(final String[] args) {
    Executor.execute(Ex8.class, args);

    StdOut.println('b');
    StdOut.println('b' + 'c');
    StdOut.println((char) ('a' + 4));
  }
}
