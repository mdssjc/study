package com.github.mdssjc.algorithms.introcs.chapter1.section14;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.4.4 Self-avoiding random walks.
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

    final int n = Integer.parseInt(args[0]);
    final int trials = Integer.parseInt(args[1]);
    int deadEnds = 0;

    for (int t = 0; t < trials; t++) {
      final boolean[][] a = new boolean[n][n];
      int x = n / 2, y = n / 2;

      while (x > 0 && x < n - 1 && y > 0 && y < n - 1) {
        a[x][y] = true;
        if (a[x - 1][y] && a[x + 1][y] && a[x][y - 1] && a[x][y + 1]) {
          deadEnds++;
          break;
        }

        final double r = Math.random();
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
