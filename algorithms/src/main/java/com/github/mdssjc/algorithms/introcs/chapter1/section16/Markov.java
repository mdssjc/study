package com.github.mdssjc.algorithms.introcs.chapter1.section16;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 1.6.3 Mixing a Markov chain.
 * <p>
 * Compilation:  javac Markov.java
 * Execution:    java Markov trials
 * Data files:   https://introcs.cs.princeton.edu/16pagerank/tiny.txt
 *               https://introcs.cs.princeton.edu/16pagerank/medium.txt
 * <p>
 * This program reads a transition matrix from standard input and
 * computes the probabilities that a random surfer lands on each page
 * (page ranks) after the specified number of matrix-vector multiplies.
 * <p>
 * % java Transition < tiny.txt | java Markov 40
 * 0.27303 0.26573 0.14618 0.24723 0.06783
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = "40", input = {
    "5", "5",
    "0.02000", "0.92000", "0.02000", "0.02000", "0.02000",
    "0.02000", "0.02000", "0.38000", "0.38000", "0.20000",
    "0.02000", "0.02000", "0.02000", "0.92000", "0.02000",
    "0.92000", "0.02000", "0.02000", "0.02000", "0.02000",
    "0.47000", "0.02000", "0.47000", "0.02000", "0.02000"
})
public class Markov {

  public static void main(final String[] args) {
    Executor.execute(Markov.class, args);

    final var trials = Integer.parseInt(args[0]);
    final var n = StdIn.readInt();
    StdIn.readInt();

    final var p = new double[n][n];
    for (var i = 0; i < n; i++) {
      for (var j = 0; j < n; j++) {
        p[i][j] = StdIn.readDouble();
      }
    }

    var rank = new double[n];
    rank[0] = 1.0;
    for (var t = 0; t < trials; t++) {
      final var newRank = new double[n];
      for (var j = 0; j < n; j++) {
        for (var k = 0; k < n; k++) {
          newRank[j] += rank[k] * p[k][j];
        }
      }

      rank = newRank;
    }

    for (var i = 0; i < n; i++) {
      StdOut.printf("%8.5f", rank[i]);
    }
    StdOut.println();

    StdOut.println();
    for (var i = 0; i < n; i++) {
      StdOut.printf("%2d  %5.3f\n", i, rank[i]);
    }
  }
}
