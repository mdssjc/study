package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Exercise 15.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("0 2 2 1 1 1")
public class Ex15 {

  public static void main(final String[] args) {
    Executor.execute(Ex15.class, args);

    final int[] a = Arrays.stream(args[0].split(" "))
                          .mapToInt(Integer::valueOf)
                          .toArray();
    final int[] h = histogram(a, a.length);

    StdOut.println(Arrays.toString(h));

    final int sum = Arrays.stream(h)
                          .sum();
    StdOut.printf("Sum: %d%nLength: %d%n", sum, a.length);
  }

  private static int[] histogram(final int[] a, final int m) {
    final int[] result = new int[m];

    for (int i = 0; i < result.length; i++) {
      if (a[i] < 0 || a[i] > m - 1) {
        throw new IllegalArgumentException();
      }
      result[a[i]]++;
    }

    return result;
  }
}
