package com.github.mdssjc.algorithms.chapter1.exercises14;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 1.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( value = "1Kints.txt", valueFile = true )
public class Ex1 {

  public static void main(final String[] args) {
    Executor.execute(Ex1.class, args);

    final int[] a = In.readInts(args[0]);
    count(a);

    final double result = (a.length * (a.length - 1) * (a.length - 2)) / 6;
    StdOut.printf("N(N-1)(N-2)/6 = %.0f%n", result);
  }

  private static int count(final int[] a) {
    int calls = 0;

    final int n = a.length;
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
          calls++;
          if (a[i] + a[j] + a[k] == 0) {
            cnt++;
          }
        }
      }
    }
    StdOut.println("Calls: " + calls);
    return cnt;
  }
}
