package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Creative Exercise 35.
 * <p>
 * Dice simulation.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class CEx35 {

  public static void main(final String[] args) {
    Executor.execute(CEx35.class, args);

    final int SIDES = 6;
    final double[] dist = new double[2 * SIDES + 1];
    for (int i = 1; i <= SIDES; i++) {
      for (int j = 1; j <= SIDES; j++) {
        dist[i + j] += 1.0;
      }
    }
    for (int k = 2; k <= 2 * SIDES; k++) {
      dist[k] /= 36.0;
    }

    print(dist);
    run(SIDES, dist);
  }

  private static void run(final int sides, final double[] dist) {
    final double[] frequency = new double[2 * sides + 1];
    boolean more = true;
    int n = 0;

    while (more) {
      final int dice1 = StdRandom.uniform(sides) + 1;
      final int dice2 = StdRandom.uniform(sides) + 1;

      frequency[dice1 + dice2]++;
      n++;

      if (n % 10 == 0 && match(distribution(frequency, n), dist)) {
        more = false;
        StdOut.printf("%d times:%n", n);
        print(distribution(frequency, n));
      }
    }
  }

  private static boolean match(final double[] distribution, final double[] dist) {
    for (int i = 2; i < distribution.length; i++) {
      final int value1 = (int) (distribution[i] * 1000.0);
      final int value2 = (int) (dist[i] * 1000.0);
      if (value1 != value2) {
        return false;
      }
    }
    return true;
  }

  private static double[] distribution(final double[] frequency, final int n) {
    final double[] distribution = new double[frequency.length];
    for (int i = 2; i < frequency.length; i++) {
      distribution[i] = frequency[i] / n;
    }
    return distribution;
  }

  private static void print(final double[] distribution) {
    for (int i = 2; i < distribution.length; i++) {
      StdOut.printf("%d: %.3f%% ", i, distribution[i] - 0.0005);
    }
    StdOut.println();
  }
}
