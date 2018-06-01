package com.github.mdssjc.algorithms.introcs.chapter1.section14;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.4.1 Sampling without replacement.
 * <p>
 * Compilation:  javac Sample.java
 * Execution:    java Sample m n
 * <p>
 * This program takes two command-line arguments m and n and produces
 * a random sample of m of the integers from 0 to n-1.
 * <p>
 * % java Sample 6 49
 * 10 20 0 46 40 6
 * <p>
 * % java Sample 10 1000
 * 656 488 298 534 811 97 813 156 424 109
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"6", "49"})
@TestDrive({"10", "1000"})
public class Sample {

  public static void main(final String[] args) {
    Executor.execute(Sample.class, args);

    final var m = Integer.parseInt(args[0]);
    final var n = Integer.parseInt(args[1]);

    final var perm = new int[n];
    for (var i = 0; i < n; i++) {
      perm[i] = i;
    }

    for (var i = 0; i < m; i++) {
      final var r = i + (int) (Math.random() * (n - i));

      final var t = perm[r];
      perm[r] = perm[i];
      perm[i] = t;
    }

    for (var i = 0; i < m; i++) {
      System.out.print(perm[i] + " ");
    }
    System.out.println();
  }
}
