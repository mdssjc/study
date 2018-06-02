package com.github.mdssjc.algorithms.introcs.chapter1.section16;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 1.6.1 Computing the transition matrix.
 * <p>
 * Compilation:  javac Transition.java
 * Execution:    java Transition < input.txt
 * Data files:   https://introcs.cs.princeton.edu/16pagerank/tiny.txt
 * https://introcs.cs.princeton.edu/16pagerank/medium.txt
 * <p>
 * This program is a filter that reads links from standard input and
 * produces the corresponding transition matrix on standard output.
 * First, it processes the input to count the outlinks from each page.
 * Then it applies the 90-10 rule to compute the transition matrix.
 * It assumes that there are no pages that have no outlinks in the
 * input (see Exercise 1.6.3).
 * <p>
 * % more tiny.txt
 * 5
 * 0 1
 * 1 2  1 2
 * 1 3  1 3  1 4
 * 2 3
 * 3 0
 * 4 0  4 2
 * <p>
 * % java Transition < tiny.txt
 * 5 5
 * 0.02 0.92 0.02 0.02 0.02
 * 0.02 0.02 0.38 0.38 0.20
 * 0.02 0.02 0.02 0.92 0.02
 * 0.92 0.02 0.02 0.02 0.02
 * 0.47 0.02 0.47 0.02 0.02
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "tiny.txt", inputFile = true)
public class Transition {

  public static void main(final String[] args) {
    Executor.execute(Transition.class, args);

    final var n = StdIn.readInt();
    final var counts = new int[n][n];
    final var outDegree = new int[n];

    while (!StdIn.isEmpty()) {
      final var i = StdIn.readInt();
      final var j = StdIn.readInt();
      outDegree[i]++;
      counts[i][j]++;
    }
    StdOut.println(n + " " + n);

    for (var i = 0; i < n; i++) {
      for (var j = 0; j < n; j++) {
        final var p = 0.90 * counts[i][j] / outDegree[i] + 0.10 / n;
        StdOut.printf("%7.5f ", p);
      }
      StdOut.println();
    }
  }
}
