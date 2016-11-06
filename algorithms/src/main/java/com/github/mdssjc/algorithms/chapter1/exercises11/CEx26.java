package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdArrayIO;

import java.util.Arrays;

/**
 * Creative Exercise 26.
 * <p>
 * Sorting three numbers.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class CEx26 {

  public static void main(final String[] args) {
    Executor.execute(CEx26.class, args);

    final int[] vector = new int[]{3, 1, 8};

    final int[] sorted = sort(vector);
    StdArrayIO.print(sorted);

    Arrays.sort(vector);
    StdArrayIO.print(vector);
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
