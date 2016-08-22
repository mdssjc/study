package com.github.mdssjc.algorithms.assignments.loops;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

@TestDrive({ "0", "1", "2", "4" })
@TestDrive({ "8", "16", "1000", "-23" })
public class Bits {

  public static void main(final String[] args) {
    Executor.execute(Bits.class, args);

    int n = Integer.parseInt(args[0]);

    if (n < 0) {
      System.out.println("Illegal input");
    } else {
      int count = 0;
      while (n > 0) {
        n /= 2;
        count++;
      }
      System.out.println(count);
    }
  }
}
