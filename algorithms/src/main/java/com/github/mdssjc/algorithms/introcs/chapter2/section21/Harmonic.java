package com.github.mdssjc.algorithms.introcs.chapter2.section21;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 2.1.1 Harmonic numbers (revisited).
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"1", "2", "4"})
@TestDrive({"10", "100", "1000", "10000"})
public class Harmonic {

  public static double harmonic(final int n) {
    double sum = 0.0;
    for (int i = 1; i <= n; i++) {
      sum += 1.0 / i;
    }
    return sum;
  }

  public static void main(final String[] args) {
    Executor.execute(Harmonic.class, args);

    for (int i = 0; i < args.length; i++) {
      final int arg = Integer.parseInt(args[i]);
      final double value = harmonic(arg);
      StdOut.println(value);
    }
  }
}
