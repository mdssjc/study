package com.github.mdssjc.algorithms.chapter1;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Implementations of static methods in StdRandom library.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class ImplementationsStdRandom {

  public static double uniform(final double a, final double b) {
    return a + StdRandom.random() * (b - a);
  }

  public static int uniform(final int n) {
    return (int) (StdRandom.random() * n);
  }

  public static int uniform(final int lo, final int hi) {
    return lo + StdRandom.uniform(hi - lo);
  }

  public static int discrete(final double[] a) {
    final var r = StdRandom.random();
    var sum = 0.0;
    for (var i = 0; i < a.length; i++) {
      sum = sum + a[i];
      if (sum >= r) {
        return i;
      }
    }
    return -1;
  }

  public static void shuffle(final double[] a) {
    final var N = a.length;
    for (var i = 0; i < N; i++) {
      final var r = i + StdRandom.uniform(N - i);
      final var temp = a[i];
      a[i] = a[r];
      a[r] = temp;
    }
  }

  public static void main(final String[] args) {
    Executor.execute(ImplementationsStdRandom.class, args);

    StdOut.println("random double value in [a, b)");
    StdOut.println(uniform(2.5, 5.5));

    StdOut.println("random int value in [0..N)");
    StdOut.println(uniform(10));

    StdOut.println("random int value in [lo..hi)");
    StdOut.println(uniform(2, 10));

    StdOut.println( "random int value drawn from discrete distribution (i with probability a[i])");
    StdOut.println(discrete(new double[]{2.5, 5.0, 7.5, 12.0}));

    StdOut.println( "randomly shuffle the elements in an array of double values");
    final var values = new double[]{8.2, 2.2, 12.0, 6.5, 5.0};

    StdArrayIO.print(values);
    shuffle(values);
    StdArrayIO.print(values);
  }
}
