package com.github.mdssjc.algorithms.introcs.chapter1.section16;

import com.github.mdssjc.algorithms.introcs.chapter1.section15.RandomSeq;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 1.6.2 Simulating a random surfer.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("100")
@TestDrive("1000000")
public class RandomSurfer {

  public static void main(final String[] args) {
    Executor.execute(RandomSeq.class, args);

    final int trials = Integer.parseInt(args[0]);
    final int n = StdIn.readInt();
    StdIn.readInt();

    final double[][] p = new double[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        p[i][j] = StdIn.readDouble();
      }
    }

    int page = 0;
    final int[] freq = new int[n];
    for (int t = 0; t < trials; t++) {
      final double r = Math.random();
      double sum = 0.0;
      for (int j = 0; j < n; j++) {
        sum += p[page][j];
        if (r < sum) {
          page = j;
          break;
        }
      }
      freq[page]++;
    }

    for (int i = 0; i < n; i++) {
      StdOut.printf("%8.5f", (double) freq[i] / trials);
    }
    StdOut.println();
  }
}
