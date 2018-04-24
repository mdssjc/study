package com.github.mdssjc.algorithms.introcs.chapter4.section42;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.2.1 Binary search (20 questions).
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("7")
public class Questions {

  public static int binarySearch(final int lo, final int hi) {
    if (hi - lo == 1) {
      return lo;
    }
    final int mid = lo + (hi - lo) / 2;
    StdOut.print("Greater than or equal to " + mid + "? ");
    if (StdIn.readBoolean()) {
      return binarySearch(lo, mid);
    } else {
      return binarySearch(mid, hi);
    }
  }

  public static void main(final String[] args) {
    Executor.execute(Questions.class, args);

    final int k = Integer.parseInt(args[0]);
    final int n = (int) Math.pow(2, k);
    StdOut.print("Think of a number ");
    StdOut.println("between 0 and " + (n - 1));
    final int guess = binarySearch(0, n);
    StdOut.println("Your number is " + guess);
  }
}
