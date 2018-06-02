package com.github.mdssjc.algorithms.introcs.chapter1.section14;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.4.4 Self-avoiding random walks.
 * <p>
 * Compilation:  javac SelfAvoidingWalk.java
 * Execution:    java SelfAvoidingWalk n trials
 * <p>
 * Generate trials self-avoiding walks of length n.
 * Report the fraction of time the random walk is non self-intersecting.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"5", "100"})
@TestDrive({"20", "100"})
@TestDrive({"40", "100"})
@TestDrive({"80", "100"})
@TestDrive({"5", "1000"})
@TestDrive({"20", "1000"})
@TestDrive({"40", "1000"})
@TestDrive({"80", "1000"})
public class SelfAvoidingWalk {

  public static void main(final String[] args) {
    Executor.execute(SelfAvoidingWalk.class, args);

    final var n = Integer.parseInt(args[0]);
    final var trials = Integer.parseInt(args[1]);
    var deadEnds = 0;

    for (var t = 0; t < trials; t++) {
      final var a = new boolean[n][n];
      var x = n / 2;
      var y = n / 2;

      while (x > 0 && x < n - 1 && y > 0 && y < n - 1) {
        if (a[x - 1][y] && a[x + 1][y] && a[x][y - 1] && a[x][y + 1]) {
          deadEnds++;
          break;
        }

        a[x][y] = true;

        final var r = Math.random();
        if (r < 0.25) {
          if (!a[x + 1][y]) {
            x++;
          }
        } else if (r < 0.50) {
          if (!a[x - 1][y]) {
            x--;
          }
        } else if (r < 0.75) {
          if (!a[x][y + 1]) {
            y++;
          }
        } else if (r < 1.00) {
          if (!a[x][y - 1]) {
            y--;
          }
        }
      }
    }

    System.out.println(100 * deadEnds / trials + "% dead ends");
  }
}
