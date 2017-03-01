package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Creative Exercise 26.
 * <p>
 * Sorting three numbers.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"3 1 8"})
public class CEx26 {

  public static void main(final String[] args) {
    Executor.execute(CEx26.class, args);

    final int[] numbers = Arrays.stream(args[0].split(" "))
                               .mapToInt(Integer::valueOf)
                               .toArray();

    StdOut.printf("Values: %s%n", Arrays.toString(numbers));

    final int[] sorted = sort(numbers);
    StdOut.printf("Sorted: %s%n", Arrays.toString(sorted));

    Arrays.sort(numbers);
    StdOut.printf("Reference: %s%n", Arrays.toString(numbers));
  }

  private static int[] sort(final int[] vector) {
    int a = vector[0];
    int b = vector[1];
    int c = vector[2];

    int t;

    if (a > b) {
      t = a;
      a = b;
      b = t;
    }

    if (a > c) {
      t = a;
      a = c;
      c = t;
    }

    if (b > c) {
      t = b;
      b = c;
      c = t;
    }

    return new int[]{a, b, c};
  }
}
