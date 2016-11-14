package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Creative Exercise 37.
 * <p>
 * Bad shuffling.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( {"10"} )
public class CEx37 {

  public static void main(final String[] args) {
    Executor.execute(CEx37.class, args);

    final int m = Integer.parseInt(args[0]);
    final int n = 200;

    final int[] a = new int[m];
    final int[][] results = new int[m][m];

    for (int times = 0; times < n; times++) {
      init(a);
      shuffle(a);

      StdOut.println(times);
      StdArrayIO.print(a);

      for (int i = 0; i < m; i++) {
        for (int j = i; j < m; j++) {
          if (i == j && a[i] == j) {
            results[i][j]++;
            break;
          }
        }
      }
    }

    StdOut.println("Results:");
    int times = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < m; j++) {
        times += results[i][j];
      }
    }
    StdOut.printf("%d times, %.1f ~ N/M = %.1f%n",
                  times, (double) (times) / m, (double) (n) / m);
  }

  private static void shuffle(final int[] a) {
    if (a == null) {
      throw new NullPointerException("argument array is null");
    } else {
      for (int i = 0; i < a.length; i++) {
        final int index = StdRandom.uniform(0, a.length);
        final int swap = a[i];
        a[i] = a[index];
        a[index] = a[swap];
      }
    }
  }

  private static void init(final int[] a) {
    for (int i = 0; i < a.length; i++) {
      a[i] = i;
    }
  }
}
