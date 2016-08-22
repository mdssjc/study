package com.github.mdssjc.algorithms.assignments.loops;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

import edu.princeton.cs.algs4.StdOut;

@TestDrive({ "0", "1", "2", "4" })
@TestDrive({ "8", "16", "1000", "-23" })
public class Bits {

  public static void main(final String[] args) {
    Executor.execute(Bits.class, args);

    int n = Integer.parseInt(args[0]);

    if (n < 0) {
      StdOut.println("Illegal input");
    } else {
      int count = 0;
      while (n > 0) {
        n /= 2;
        count++;
      }
      StdOut.println(count);
    }
  }
}
