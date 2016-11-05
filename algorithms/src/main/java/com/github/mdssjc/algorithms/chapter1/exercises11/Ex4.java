package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 4.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex4 {

  public static void main(final String[] args) {
    Executor.execute(Ex4.class, args);

    // if (a > b) then c = 0;
    StdOut.println("syntax error");
    // if a > b { c = 0; }
    StdOut.println("syntax error");
    // if (a > b) c = 0;
    StdOut.println("ok");
    // if (a > b) c = 0 else b = 0;
    StdOut.println("syntax error");
  }
}
