package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Creative Exercise 36.
 * <p>
 * Empirical shuffle check.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( {"10", "200"} )
public class CEx36 {

  public static void main(final String[] args) {
    Executor.execute(CEx36.class, args);

    final int m = Integer.parseInt(args[0]);
    final int n = Integer.parseInt(args[1]);

    final int[] a = new int[m];
    final int[][] results = new int[m][m];

    for (int times = 0; times < n; times++) {
      init(a);
      StdRandom.shuffle(a);

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

  private static void init(final int[] a) {
    for (int i = 0; i < a.length; i++) {
      a[i] = i;
    }
  }
}
