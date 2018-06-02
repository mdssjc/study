package com.github.mdssjc.algorithms.introcs.chapter1.section16;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 1.6.2 Simulating a random surfer.
 * <p>
 * Compilation:  javac RandomSurfer.java
 * Execution:    java RandomSurfer trials
 * Data files:   https://introcs.cs.princeton.edu/16pagerank/tiny.txt
 *               https://introcs.cs.princeton.edu/16pagerank/medium.txt
 * <p>
 * % java Transition < tiny.txt | java RandomSurfer 1000000
 * 0.27297 0.26583 0.14598 0.24729 0.06793
 *
 * @author Marcelo dos Santos
 */
@TestDrive(value = "1000000", input = {
    "5", "5",
    "0.02000", "0.92000", "0.02000", "0.02000", "0.02000",
    "0.02000", "0.02000", "0.38000", "0.38000", "0.20000",
    "0.02000", "0.02000", "0.02000", "0.92000", "0.02000",
    "0.92000", "0.02000", "0.02000", "0.02000", "0.02000",
    "0.47000", "0.02000", "0.47000", "0.02000", "0.02000"
})
public class RandomSurfer {

  public static void main(final String[] args) {
    Executor.execute(RandomSurfer.class, args);

    final var trials = Integer.parseInt(args[0]);
    final var m = StdIn.readInt();
    final var n = StdIn.readInt();
    if (m != n) {
      StdOut.println("m does not equal n");
      return;
    }

    final var p = new double[n][n];
    for (var i = 0; i < n; i++) {
      for (var j = 0; j < n; j++) {
        p[i][j] = StdIn.readDouble();
      }
    }

    final var freq = new int[n];

    var page = 0;

    for (var t = 0; t < trials; t++) {
      final var r = Math.random();
      var sum = 0.0;
      for (var j = 0; j < n; j++) {
        sum += p[page][j];
        if (r < sum) {
          page = j;
          break;
        }
      }
      freq[page]++;
    }

    for (var i = 0; i < n; i++) {
      StdOut.printf("%8.5f", (double) freq[i] / trials);
    }
    StdOut.println();
  }
}
