package com.github.mdssjc.algorithms.chapter1.section11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * RandomSeq Class.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( {"5", "100.0", "200.0"} )
public class RandomSeq {

  public static void main(final String[] args) {
    Executor.execute(RandomSeq.class, args);

    // Print N random values in (lo, hi).
    final int N = Integer.parseInt(args[0]);
    final double lo = Double.parseDouble(args[1]);
    final double hi = Double.parseDouble(args[2]);
    for (int i = 0; i < N; i++) {
      final double x = StdRandom.uniform(lo, hi);
      StdOut.printf("%.2f\n", x);
    }
  }
}
