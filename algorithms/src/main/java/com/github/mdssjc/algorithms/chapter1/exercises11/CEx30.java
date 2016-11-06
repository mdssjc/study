package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.chapter1.section11.Euclid;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdArrayIO;

/**
 * Creative Exercise 30.
 * <p>
 * Array exercise.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class CEx30 {

  public static void main(final String[] args) {
    Executor.execute(CEx30.class, args);

    final boolean[][] a = new boolean[10][10];

    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        a[i][j] = isPrime(i, j);
      }
    }

    StdArrayIO.print(a);
  }

  private static boolean isPrime(final int i, final int j) {
    if (i <= 1 || j <= 1) {
      return false;
    }
    return Euclid.gcd(i, j) == 1;
  }
}
