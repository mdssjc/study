package com.github.mdssjc.algorithms.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 7.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex7 {

  public static void main(final String[] args) {
    Executor.execute(Ex7.class, args);

    StdOut.println(mystery("marcelo"));
  }

  public static String mystery(final String s) {
    final int N = s.length();
    if (N <= 1) {
      return s;
    }
    final String a = s.substring(0, N / 2);
    final String b = s.substring(N / 2, N);
    return mystery(b) + mystery(a);
  }
}
