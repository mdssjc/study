package com.github.mdssjc.algorithms.introcs.chapter1.section14;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.4.1 Sampling without replacement.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"6", "16"})
@TestDrive({"10", "1000"})
@TestDrive({"20", "20"})
public class Sample {

  public static void main(final String[] args) {
    Executor.execute(Sample.class, args);

    final int m = Integer.parseInt(args[0]);
    final int n = Integer.parseInt(args[1]);
    final int[] perm = new int[n];

    for (int j = 0; j < n; j++) {
      perm[j] = j;
    }

    for (int i = 0; i < m; i++) {
      final int r = i + (int) (Math.random() * (n - i));
      final int t = perm[r];
      perm[r] = perm[i];
      perm[i] = t;
    }

    for (int i = 0; i < m; i++) {
      System.out.print(perm[i] + " ");
    }
    System.out.println();
  }
}
