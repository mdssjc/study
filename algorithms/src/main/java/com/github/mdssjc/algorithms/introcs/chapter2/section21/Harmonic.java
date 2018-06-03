package com.github.mdssjc.algorithms.introcs.chapter2.section21;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 2.1.1 Harmonic numbers (revisited).
 * <p>
 * Compilation:  javac Harmonic.java
 * Execution:    java Harmonic n
 * <p>
 * Prints the nth harmonic number: 1/1 + 1/2 + ... + 1/n.
 * <p>
 * % java Harmonic 10
 * 2.9289682539682538
 * <p>
 * % java Harmonic 10000
 * 9.787606036044348
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("10")
@TestDrive("10000")
public class Harmonic {

  public static double harmonic(final int n) {
    var sum = 0.0;
    for (var i = 1; i <= n; i++) {
      sum += 1.0 / i;
    }
    return sum;
  }

  public static void main(final String[] args) {
    Executor.execute(Harmonic.class, args);

    for (var i = 0; i < args.length; i++) {
      final var arg = Integer.parseInt(args[i]);
      final var value = harmonic(arg);
      StdOut.println(value);
    }
  }
}
