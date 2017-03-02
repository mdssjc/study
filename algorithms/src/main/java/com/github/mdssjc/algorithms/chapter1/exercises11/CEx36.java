package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * Creative Exercise 36.
 * <p>
 * Empirical shuffle check.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"10", "200"})
public class CEx36 {

  public static void main(final String[] args) {
    Executor.execute(CEx36.class, args);

    final int m = Integer.parseInt(args[0]);
    final int n = Integer.parseInt(args[1]);

    final int[] a = new int[m];
    final int[][] dist = new int[m][m];

    for (int times = 0; times < n; times++) {
      init(a);
      StdRandom.shuffle(a);
      StdOut.printf("%d: %s%n", times, Arrays.toString(a));

      for (int i = 0; i < a.length; i++) {
        dist[i][a[i]]++;
      }
    }

    final double times = average(dist, m);

    StdOut.println("Results:");
    StdArrayIO.print(dist);
    StdOut.printf("%.1f times, %.1f ~ N/M = %.1f%n",
                  times, times / m, (double) (n) / m);
  }

  private static void init(final int[] a) {
    for (int i = 0; i < a.length; i++) {
      a[i] = i;
    }
  }

  private static double average(final int[][] dist, final int m) {
    int sum;
    double times = 0;

    for (int i = 0; i < m; i++) {
      sum = 0;
      for (int j = 0; j < m; j++) {
        sum += dist[i][j];
      }
      times += (double) (sum) / m;
    }

    return times;
  }
}
