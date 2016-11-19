package com.github.mdssjc.algorithms.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

import java.util.stream.IntStream;

/**
 * Exercise 8.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex8 {

  public static void main(final String[] args) {
    Executor.execute(Ex8.class, args);

    int[] a = IntStream.range(0, 1000)
                       .toArray();
    int[] b = IntStream.range(1000, 2000)
                       .toArray();

    final int[] t = a;
    a = b;
    b = t;

    StdOut.println(check(a, b));
  }

  private static boolean check(final int[] a, final int[] b) {
    for (int i = 0; i < a.length; i++) {
      if (a[i] != i + 1000 && b[i] != i) {
        return false;
      }
    }
    return true;
  }
}
