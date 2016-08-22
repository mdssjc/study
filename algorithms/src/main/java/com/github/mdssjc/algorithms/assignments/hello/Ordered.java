package com.github.mdssjc.algorithms.assignments.hello;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

import edu.princeton.cs.algs4.StdOut;

@TestDrive({ "10", "17", "49" })
@TestDrive({ "49", "17", "10" })
@TestDrive({ "10", "49", "17" })
public class Ordered {

  private static boolean isOrdered(final int x, final int y, final int z) {
    // return (x < y && y < z || x > y && y > z);
    if (x > y) {
      if (y > z) {
        return true;
      }
    }
    if (z > y) {
      if (y > x) {
        return true;
      }
    }
    return false;
  }

  public static void main(final String[] args) {
    Executor.execute(Ordered.class, args);

    final int x = Integer.parseInt(args[0]);
    final int y = Integer.parseInt(args[1]);
    final int z = Integer.parseInt(args[2]);

    StdOut.println(isOrdered(x, y, z));
  }
}
