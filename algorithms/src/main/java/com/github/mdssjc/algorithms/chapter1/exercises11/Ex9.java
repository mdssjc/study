package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 9.
 * 
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex9 {

  public static void main(final String[] args) {
    Executor.execute(Ex9.class, args);

    final int in = 5;

    String s = Integer.toBinaryString(in);
    StdOut.println(s);

    s = "";
    for (int n = in; n > 0; n /= 2) {
      s = (n % 2) + s;
    }
    StdOut.println(s);
  }
}
